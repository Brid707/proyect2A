
/*
 * lineCounter.java
 *
 * Copyright (c) 2025 Bridget Mendez. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Bridget Men>
 * ("Confidential Information"). You shall not disclose such Confidential Infor>
 * and shall use it only in accordance with the terms of the license agreement >
 * entered into with Bridget Mendez.
 *
 * BRIDGET MENDEZ MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY >
 * THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE IM>
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, OR NON-INFR>
 * NOMBRE APELLIDO SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A
 * RESULT OF USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 */
/**
 * Clase que cuenta las líneas de código (LOC) de un conjunto de datos fuente.
 *
 * @version 1.0 04/11/2025
 * @author Bridget Mendez
 */
public class lineCounter {

  private int totalLines;
    private String[] arrData;
    /**
     * Constructor por defecto.
     */
    public lineCounter() {
    }
    /**
     * Establece los datos fuente sobre los que se realizará el conteo de líneas.
     * @param newArr los datos fuente como arreglo de cadenas
     */
    public void setArrData(String[] newArr) {
        this.arrData = newArr;
    }
    /**
     * Obtiene el total de líneas de código contadas.
     * @return el número total de líneas de código
     */
    public int getTotalLines() {
        return totalLines;
    }
    /**
     * Realiza el conteo de líneas de código (excluyendo comentarios y líneas en blanco).
     */
    public void count() {
        totalLines = 0;
        boolean inBlockComment = false;
        for (String line : arrData) {
            String trimmed = line.trim();
            if (trimmed.isEmpty()) {
                continue;
            }
            if (!inBlockComment) {
                if (trimmed.startsWith("/*")) {
                    inBlockComment = true;
                    if (trimmed.endsWith("*/") || trimmed.contains("*/")) {
                        inBlockComment = false;
                    }
                    continue;
                }
                if (trimmed.startsWith("//")) {
                    continue;
                }
                // Remover comentarios de fin de línea
                int index = trimmed.indexOf("//");
                if (index != -1) {
                    trimmed = trimmed.substring(0, index).trim();
                }
                index = trimmed.indexOf("/*");
                if (index != -1) {
                    trimmed = trimmed.substring(0, index).trim();
                }
                if (trimmed.isEmpty()) {
                    continue;
                }
                // Omitir líneas que solo tienen llaves { o }
                if (trimmed.equals("{") || trimmed.equals("}") || trimmed.equals("{;") || trimmed.equals("};")) {
                    continue;
                }
                // Contar la línea como LOC
                totalLines++;
            } else {
                // Estamos dentro de un bloque de comentario
                if (trimmed.contains("*/")) {
                    inBlockComment = false;
                }
            }
        }
    }
}
