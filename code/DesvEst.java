/*
 * DesvEst.java
 *
 * Copyright (c) 2025 Bridget Mendez. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Bridget Men>
 * ("Confidential Information"). You shall not disclose such Confidential Infor>
 * and shall use it only in accordance with the terms of the license agreement >
 * entered into with Bridget Mendez.
 *
 * Bridget Mendez MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY >
 * THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE IM>
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, OR NON-INFR>
 * NOMBRE APELLIDO SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A
 * RESULT OF USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 */

import java.io.*;
import java.util.*;

/**
 * Clase para calcular la desviación estándar de un conjunto de valores numéricos.
 *
 * @version 1.0 04/11/2025
 * @author Bridget Mendez
 */
public class DesvEst {

    private double standardDeviation;
    /**
     * Constructor por defecto.
     */
    public DesvEst() {
    }
    /**
     * Calcula la desviación estándar de los valores numéricos almacenados en el objeto Data proporcionado.
     * @param data el objeto Data con los valores numéricos como cadenas
     * @return la desviación estándar calculada
     */
    public double calculate(Data data) {
        String[] values = data.getAllData();
        int n = values.length;
        if (n == 0) {
            standardDeviation = 0;
            return standardDeviation;
        }
        // Calcular la media
        double sum = 0;
        for (String val : values) {
            try {
                sum += Double.parseDouble(val);
            } catch (NumberFormatException e) {
                // Ignorar valores no numéricos
            }
        }
        double mean = (n > 0) ? (sum / n) : 0;
        // Calcular la suma de cuadrados de las diferencias
        double sumSqDiff = 0;
        for (String val : values) {
            try {
                double num = Double.parseDouble(val);
                sumSqDiff += Math.pow(num - mean, 2);
            } catch (NumberFormatException e) {
                // Ignorar valores no numéricos
            }
        }
        // Usar n para la población completa
        standardDeviation = (n > 0) ? Math.sqrt(sumSqDiff / n) : 0;
        return standardDeviation;
    }
    /**
     * Devuelve la desviación estándar calculada.
     * @return el valor de la desviación estándar
     */
    public double getStandardDeviation() {
        return standardDeviation;
    }
}
