/*
 * Media.java
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
 * Clase para calcular el promedio (media) de un conjunto de valores numéricos.
 *
 * @version 1.0 04/11/2025
 * @author Bridget Mendez
 */
public class Media {
    private double average;
     /**
     * Constructor por defecto.
     */

    public Media() {
    }
     /**
     * Calcula la media de los valores numéricos almacenados en el objeto Data proporcionado.
     * @param data el objeto Data que contiene los valores numéricos como cadenas
     * @return la media calculada
     */
     public double calculate(Data data) {
          String[] values = data.getAllData();
          int n = values.length;
          double sum = 0;
          for (String val : values) {
               try {
                    sum += Double.parseDouble(val);
               } catch (NumberFormatException e) {
                // Ignorar valores no numéricos
               }
          }
          average = (n > 0) ? (sum / n) : 0;
          return average;
    }
    /**
     * Devuelve la media calculada.
     * @return el valor de la media
     */
    public double getAverage() {
        return average;
    }
}
