//
//  matrix.cpp
//  matrix
//
//  Created by Mudit Sahni on 27/03/19.
//  Copyright © 2019 Mudit Sahni. All rights reserved.
//

#include <iostream>
#include "matrix.hpp"
using namespace std;

Matrix::Matrix() {
    vector < vector <float > > initial_grid (4, vector <float> (4,0));
    grid = initial_grid;
    rows = initial_grid.size();
    cols = initial_grid[0].size();
    
}


Matrix::Matrix(vector < vector <float> > initial_grid) {
    grid = initial_grid;
    rows = initial_grid.size();
    cols = initial_grid[0].size();
    
}


void Matrix::setGrid(vector < vector <float> > new_grid) {
    grid = new_grid;
    rows = new_grid.size();
    cols = new_grid[0].size();
    
}

vector < vector <float> > Matrix::getGrid() {
    return grid;
}

vector <float>::size_type Matrix::getRows() {
    return rows;
}

vector <float>::size_type Matrix::getCols() {
    return cols;
}

vector < vector <float> > Matrix::matrix_transpose() {
    vector < vector <float> > transposed_matrix(cols, vector <float> (rows, 0));
    for(int row=0;row<rows;row++) {
        for(int col=0;col<cols;col++) {
            transposed_matrix[col][row] = grid[row][col];
        }
    }
    return transposed_matrix;
}

vector < vector <float> > Matrix::matrix_addition(Matrix Other) {
    float new_rows = Other.getRows();
    float new_cols = Other.getCols();
    vector < vector <float> > other_grid = Other.getGrid();
    if(new_rows != rows || new_cols != cols){
        throw(std::invalid_argument("Matrices are not of the same size"));
    }
    else {
        vector < vector <float> > matrixsumresult (rows, vector <float> (cols, 0));
        for(int row=0;row<rows;row++) {
            for(int col=0;col<cols;col++) {
                matrixsumresult[row][col] = grid[row][col] + other_grid[row][col];
            }
        }
        return matrixsumresult;
    }
}

vector < vector <float> > Matrix::dot_product(Matrix Other) {
    float new_rows = Other.getRows();
    float new_cols = Other.getCols();
    vector < vector <float> > other_grid = Other.getGrid();
    
    if(cols != new_rows) {
        throw(std::invalid_argument("Rows and columns do not match."));
    }
    else {
        vector < vector <float> > dp_matrix(rows, vector <float> (new_cols,0));
        for(int m_row = 0; m_row < rows; m_row++) {
            for(int col = 0; col < new_cols; col++) {
                float temp = 0.;
                    for(int row =0; row < cols; row++) {
                        temp += grid[m_row][row] * other_grid[row][col];
                    }
                dp_matrix[m_row][col] = temp;
        }
    }
        
        return dp_matrix;
    }
}

void Matrix::matrix_print() {
    vector < vector <float> > M = grid;
        for(int x = 0; x < rows; x++) {
            for(int y=0;y < cols; y++) {
                cout<<M[x][y]<<" ";
            }
            cout<<endl;
        }
}

