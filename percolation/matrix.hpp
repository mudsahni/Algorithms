//
//  matrix.hpp
//  matrix
//
//  Created by Mudit Sahni on 27/03/19.
//  Copyright © 2019 Mudit Sahni. All rights reserved.
//

#ifndef matrix_hpp
#define matrix_hpp

#include <vector>
using namespace std;

class Matrix
{
private:
    vector < vector <float> > grid;
    vector <float>::size_type rows;
    vector <float>::size_type cols;
    
public:
    // constructors
    Matrix();
    Matrix(vector < vector <float> >);
    
    // set function
    void setGrid(vector < vector <float> >);
    
    // get functions
    vector < vector <float> > getGrid();
    vector <float>::size_type getRows();
    vector <float>::size_type getCols();

    // matrix functions
    vector < vector <float> > matrix_transpose();
    vector < vector <float> > matrix_addition(Matrix);
    vector < vector <float> > dot_product(Matrix);
    //float find_cofactor(vector < vector <float> >);
    //float determinant();
    void matrix_print();
    
};


#endif /* matrix_hpp */
