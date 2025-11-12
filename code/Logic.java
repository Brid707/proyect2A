
/*
 * Logic.java
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

import java.io.*;
import java.util.*;
import java.util.Scanner;

/**
 * Clase que coordina la lógica del programa: lectura, conteo y salida de resultados.
 *
 * @version 1.3 05/11/2025
 * @author Bridget Mendez
*/
/*
* Logic.java
*
* Contador automático de clases Java para PSP 0.1
*/


import java.io.*;
import java.util.*;


public class Logic {


   public void logical() {
       File currentDir = new File("/home/bridget/Documentos/Procesos-isw/Bridget-isw/code/Model");
       File[] javaFiles = currentDir.listFiles((dir, name) -> name.endsWith(".java"));


       if (javaFiles == null || javaFiles.length == 0) {
           System.out.println("No se encontraron archivos .java en el directorio actual.");
           return;
       }


       String programName = "Programa2";
       int finalLOC = 0;
       StringBuilder finOut = new StringBuilder();


       String header = String.format("%-15s %-20s %15s %15s %15s\n",
           "Programa", "Nombre de Clase", "Métodos", "LOC Clase", "LOC Total");

       finOut.append(header);
       System.out.print(header);


       boolean firstRow = true;


       for (File file : javaFiles) {
           String className = file.getName().replace(".java", "");
           Data data = new Data();
           Input input = new Input();
           input.readData(file.getName(), data);


           lineCounter lc = new lineCounter();
           lc.setArrData(data.getAllData());
           lc.count();


           MethodCounter mc = new MethodCounter();
           mc.setArrData(data.getAllData());
           mc.count();


           int loc = lc.getTotalLines();
           int methods = mc.getTotalMethods();
           finalLOC += loc;


           String progColumn = firstRow ? programName : "";
           String row = String.format("%-15s %-20s %15d %15d %15s\n",
           progColumn, className, methods, loc, "");
           finOut.append(row);
           System.out.print(row);


           firstRow = false;
       }


       // Agregar fila total
       String totalRow = String.format("%-15s %-20s %15s %15s %15d\n",
       "", "", "", "", finalLOC);
       finOut.append(totalRow);
       System.out.print(totalRow);


       // Guardar resultados
       OutPut output = new OutPut();
       output.writeData("Programa2_ConteoLOC.txt", finOut.toString());
       }
} 
