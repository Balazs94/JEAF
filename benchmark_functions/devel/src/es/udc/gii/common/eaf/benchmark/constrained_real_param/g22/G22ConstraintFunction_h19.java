/*
* Copyright (C) 2010 Grupo Integrado de Ingeniería
* 
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
* 
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details.
* 
* You should have received a copy of the GNU General Public License
* along with this program. If not, see <http://www.gnu.org/licenses/>.
*/ 


/*
 * G01ConstraintFunction_1.java
 *
 * Created on 27 de agosto de 2007, 19:36
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package es.udc.gii.common.eaf.benchmark.constrained_real_param.g22;

import es.udc.gii.common.eaf.problem.constraint.EqualityConstraint;

/**
 *
 * @author Grupo Integrado de Ingeniería (<a href="http://www.gii.udc.es">www.gii.udc.es</a>) 
 * @since 1.0
 */
public class G22ConstraintFunction_h19 extends EqualityConstraint {
    
    /** Creates a new instance of G01ConstraintFunction_1 */
    public G22ConstraintFunction_h19() {
    }
    
    @Override
    public double evaluate(double[] values) {
        
        double constraintValue = Double.MAX_VALUE;
        double x9, x12, x15, x22;
        double[] norm_values;

        norm_values = G22Function.normalize(values);
        
        x9 = norm_values[8];
        x12 = norm_values[11];
        x15 = norm_values[14];
        x22 = norm_values[21];
        
        constraintValue = x9 - x12 - 4.60517 * x15 + x15 * x22 + 100.0;
        
        return constraintValue;
    }
    
    
}