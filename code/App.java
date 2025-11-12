/*
 * App.java
 *
 * Copyright (c) 2025 Bridget Mendez. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Bridget Mendez.
 * ("Confidential Information"). You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the license agreement you
 * entered into with Bridget Mendez.
 *
 * Bridget Mendez MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF
 * THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, OR NON-INFRINGEMENT.
 * NOMBRE APELLIDO SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A
 * RESULT OF USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 */
import java.io.*;
import java.util.*;

/**
 *clase principal que contiene el metodo main para iniciar el programa.
 *@1.0 04/11/2025
 *Bridget Mendez 
 */
public class App {

    /**
     * Default constructor
     */
    public App() {
    }
    /**
     *punto de entrada principal del programa.
     */
    public static void main (String[]arg) {
	Logic logic = new Logic();
        logic.logical();
        // TODO implement here
    }

}
