/*
 * MethodCounter.java
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
 * Clase que cuenta el número de métodos en un conjunto de datos fuente.
 *
 * @version 1.0 04/11/2025
 * @author Nombre Apellido
 */
public class MethodCounter {
    private int totalMethods;
    private String[] arrData;
    /**
     * Constructor por defecto.
     */
    public MethodCounter() {
    }
    /**
     * Establece los datos fuente sobre los que se realizará el conteo de métodos.
     * @param newArr los datos fuente como arreglo de cadenas
     */
    public void setArrData(String[] newArr) {
        this.arrData = newArr;
    }
    /**
     * Obtiene el total de métodos contados.
     * @return el número total de métodos
     */
    public int getTotalMethods() {
        return totalMethods;
    }
    /**
     * Realiza el conteo de métodos en el código fuente.
     */
    public void count() {
        totalMethods = 0;
        boolean inBlockComment = false;
        for (int i = 0; i < arrData.length; i++) {
            String line = arrData[i];
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
                // Verificar si la línea contiene declaración de método
                if ((trimmed.endsWith(")") || trimmed.contains(")")) && trimmed.contains("(")) {
                    // Excluir palabras clave de control
                    if (trimmed.startsWith("if") || trimmed.startsWith("for") || trimmed.startsWith("while") || trimmed.startsWith("switch") || trimmed.startsWith("catch")) {
                        continue;
                    }
                    // Si la línea no termina en '{', revisar la siguiente línea
                    if (!trimmed.endsWith("{")) {
                        if (i < arrData.length - 1) {
                            String next = arrData[i+1].trim();
                            if (!next.startsWith("{")) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    }
                    totalMethods++;
                }
            } else {
                // Estamos dentro de un bloque de comentario
                if (trimmed.contains("*/")) {
                    inBlockComment = false;
                }
            }
        }
    }
}
