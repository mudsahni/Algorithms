const datetime = require('moment');
const FORMAT = "YYYY-MM-DD";
// let startDate = datetime("2019-05-11", "YYYY-M-DD HH:mm:ss")
// let endDate = datetime("2019-06-11", "YYYY-M-DD HH:mm:ss")
// let diff = endDate.diff(startDate, "days");
// // console.log(diff);
// let now = datetime();
// // console.log(now.format("YYYY-MM-DD"));

class DateRange {
    constructor(start, end) {
        this.start = start;
        this.end = end;
        this.difference = end.diff(start, "days");
        this.format = "YYYY-MM-DD";
    };

    printRange() {
        return `${this.start.format(this.format)} ===> ${this.end.format(this.format)}`;
    };

    printStart() {
        return `${this.start.format(this.format)}`;
    };

    printEnd() {
        return `${this.end.format(this.format)}`;
    };
    
    greaterRange(dr2) {
        return this.difference > dr2.difference;
    };

    equalRange(dr2) {
        return this.difference == dr2.difference;
    };

    startsFirst(dr2) {
        return this.start < dr2.start;
    };

    endsFirst(dr2) {
        return this.start < dr2.start;
    };

    overlap(dr2) {
        let latestStart = datetime.max(this.start, dr2.start);
        let earliestEnd = datetime.min(this.end, dr2.end);
        let delta = earliestEnd.diff(latestStart, "days") + 1;
        return Math.max(0, delta);
    };

    isOverlap(dr2) {
        return this.overlap(dr2) != 0;
    };

};

let makeDateTimeObject = function(day, month, year) {
    return datetime(`${year}-${month}-${day}`, FORMAT);
};

let getRandomInteger = function(min, max) {
    return Math.floor(Math.random() * (max-min)) + min;
};

let getRandomDate = function(start) {
    const MAX_DAYS = 30;
    const MIN_DAYS = 3;
    let temp = start.clone();
    let numberOfDays = getRandomInteger(MIN_DAYS, MAX_DAYS);
    numberOfDays = numberOfDays%temp.daysInMonth() == numberOfDays ? 
                   numberOfDays : temp.daysInMonth() - numberOfDays;
    let newDate = datetime(temp.add(numberOfDays, "days").format(FORMAT));
    return newDate;
};

let getDate = function(spread, year) {
    let month = getRandomInteger(1,spread);
    let _temp = datetime(`${year}-${spread}`, FORMAT);
    let day = getRandomInteger(1, _temp.daysInMonth());
    return makeDateTimeObject(day, month, year);
};

let generateJobs = function(n, spread, year) {
    let dateRanges = [];
    for(let i=0; i < n; i++) {
        let start = getDate(spread, year);
        let end = getRandomDate(start);
        dateRange = new DateRange(start, end);
        dateRanges.push(dateRange);
    };
    return dateRanges;
};

let any = function(iterable) {
    for (let idx=0; idx<iterable.length; idx++) {
        if(iterable[idx]){
            return true;
        }
    }
    return false;
};

let argsort = function(array, dec=false) {
    return Array.from(Array(array.length).keys()).sort((a,b) => 
           array[a] < array[b] ? (dec ? 0 : -1) : 
           (array[b] < array[a]) | (dec ? -1 : 0));
};

let checkOverlap = function(date, dateRanges) {
    let d;
    for (d of dateRanges) {
        console.log(`Checking overlap with previous date: ${d.printRange()}`);
        if (date.isOverlap(d)) {
            console.log(`Overlap with date: ${d.printRange()};`);
            return false;
        }
        else {
            console.log(`No overlap with date: ${d.printRange()}`);
            continue;
        }
    }
    console.log(`No overlap with any previous dates.`);

    return true;
};

let earliestJobFirst = function(dateRanges) {
    let datesToTake = [];
    let sortedDateRanges = argsort(dateRanges, true);
    datesToTake.push(dateRanges[sortedDateRanges[0]]);
    console.log(`Job which starts the first: ${dateRanges[sortedDateRanges[0]].printRange()}`);
    let otherDate;
    let takeDate;
    for(otherDate of sortedDateRanges.slice(1,)){
        console.log(`Next earliest starting job: ${dateRanges[otherDate].printRange()}`);
        takeDate = checkOverlap(dateRanges[otherDate], datesToTake);
    if(takeDate) {
        datesToTake.push(dateRanges[otherDate]);
        console.log(`Appending to taken jobs list: ${dateRanges[otherDate].printRange()}`);
    }
    console.log("=============================================");
    };
    return datesToTake;
};   


let x1 = datetime("2018-10-12", FORMAT);
let y1 = datetime("2019-11-12", FORMAT);

let x2 = datetime("2019-10-20", FORMAT);
let y2 = datetime("2019-11-20", FORMAT);

let X = new DateRange(x1, y1);
let Y = new DateRange(x2, y2);

console.log(x1.daysInMonth());

let dateRanges = generateJobs(30,7,2019);

let jobsToTake = earliestJobFirst(dateRanges);
for(let j=0;j<jobsToTake.length;j++){
    console.log(jobsToTake[j].printRange());
};