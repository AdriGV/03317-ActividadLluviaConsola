/* 
 * Copyright 2019 AdrianGV  adrian.gimeno.alum@iescamp.es.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.main;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author AdrianGV adrian.gimeno.alum@iescamp.es
 */
public final class Main {

    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");

    public static final Random RND = new Random();

    public static void main(String[] args) {

        //Contantes
        final int MAX_LLUVIA = 500;
        final int MIN_LLUVIA = 0;
        final int DIAS_WEEK = 7;

        //Variable
        int litros;
        int litrosMax = 0;
        int litrosMin = 500;
        int media;
        int totalLitros = 0;
        String day = null;
        String dayMin = null;
        String dayMax = null;
        int diaLitrosMax = 0;
        int diaLitrosMin = 0;

        for (int dia = 0; dia < DIAS_WEEK; dia++) {

            switch (dia + 1) {
                case 1:
                    day = "Lunes";
                    break;
                case 2:
                    day = "Martes";
                    break;
                case 3:
                    day = "Miércoles";
                    break;
                case 4:
                    day = "Jueves";
                    break;
                case 5:
                    day = "Viernes";
                    break;
                case 6:
                    day = "Sábado";
                    break;
                case 7:
                    day = "Domingo";
            }

            //Random de la cantidad
            litros = RND.nextInt(MAX_LLUVIA - MIN_LLUVIA + 1) + MIN_LLUVIA;

            //Mensaje
            System.out.printf("Litros del %s -> %d l/m2 %n", day, litros);

            //Total de litros
            totalLitros += litros;

            //Sacamos el mayor
            if (litros > litrosMax) {
                litrosMax = litros;
                diaLitrosMax = dia;
            }
            //Sacamos el menor
            if (litros < litrosMin) {
                litrosMin = litros;
                diaLitrosMin = dia;
            }
        }

        //Media
        media = totalLitros / DIAS_WEEK;

        //Separador
        System.out.println("<--->");
        
        //Mensaje total Litros
        System.out.printf("Total litros acumulados -> %d%n", totalLitros);

        //Separador
        System.out.println("<--->");
        
        //MensajeMedia
        System.out.printf("La media del total es %d%n", media);

        //Sirve para indicar el día con mas lluvia
        switch (diaLitrosMax + 1) {
            case 1:
                dayMax = "Lunes";
                break;
            case 2:
                dayMax = "Martes";
                break;
            case 3:
                dayMax = "Miércoles";
                break;
            case 4:
                dayMax = "Jueves";
                break;
            case 5:
                dayMax = "Viernes";
                break;
            case 6:
                dayMax = "Sábado";
                break;
            case 7:
                dayMax = "Domingo";
        }

        //Separador
        System.out.println("<--->");
        
        //Mensaje con el dia de mas lluvia
        System.out.printf("El día con mayor lluvia es el %s con %d l/m2%n",
                dayMax, litrosMax);

        switch (diaLitrosMin + 1) {
            case 1:
                    dayMin = "Lunes";
                    break;
                case 2:
                    dayMin = "Martes";
                    break;
                case 3:
                    dayMin = "Miércoles";
                    break;
                case 4:
                    dayMin = "Jueves";
                    break;
                case 5:
                    dayMin = "Viernes";
                    break;
                case 6:
                    dayMin = "Sábado";
                    break;
                case 7:
                    dayMin = "Domingo";
        }
        
        //Separador
        System.out.println("<--->");
        //Mensaje
        System.out.printf("El dia con menor lluvia es %s con %d l/m2%n",
                dayMin, litrosMin);

        }
    }
