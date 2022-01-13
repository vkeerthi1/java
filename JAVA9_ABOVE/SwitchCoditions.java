package com.ds.string;
enum Day { SUNDAY, MONDAY, TUESDAY,
    WEDNESDAY, THURSDAY, FRIDAY, SATURDAY; }

public class SwitchCoditions {
    public static void main(String[] args) {
        //Switch statements

        int numLetters = 0;
        Day day = Day.WEDNESDAY;
        switch (day) {
            case MONDAY:
            case FRIDAY:
            case SUNDAY:
                numLetters = 6;
                break;
            case TUESDAY:
                numLetters = 7;
                break;
            case THURSDAY:
            case SATURDAY:
                numLetters = 8;
                break;
            case WEDNESDAY:
                numLetters = 9;
                break;
            default:
                throw new IllegalStateException("Invalid day: " + day);
        }
        System.out.println(numLetters);

        //switch case
        //case label_1, label_2, ..., label_n -> expression;|throw-statement;|block
        //If the code to the right of the arrow is an expression, then the value of that expression is the value of the switch expression.
        Day day = Day.WEDNESDAY;
        System.out.println(
                switch (day) {
                    case MONDAY, FRIDAY, SUNDAY -> 6;
                    case TUESDAY                -> 7;
                    case THURSDAY, SATURDAY     -> 8;
                    case WEDNESDAY              -> 9;
                    default -> throw new IllegalStateException("Invalid day: " + day);
                }
        );

        //You can use the new kind of case label in switch statements.
        //except it uses "case L ->" labels instead of "case L:" labels:
        //*******************************************************
        // A "case L ->" label along with its code to its right is called a switch labeled rule.
        int numLetters = 0;
        Day day = Day.WEDNESDAY;
        switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> numLetters = 6;
            case TUESDAY                -> numLetters = 7;
            case THURSDAY, SATURDAY     -> numLetters = 8;
            case WEDNESDAY              -> numLetters = 9;
            default -> throw new IllegalStateException("Invalid day: " + day);
        };
        System.out.println(numLetters);

        //"case L:" Statements and the yield Statement
        Day day = Day.WEDNESDAY;
        int numLetters = switch (day) {
            case MONDAY:
            case FRIDAY:
            case SUNDAY:
                System.out.println(6);
                yield 6;
            case TUESDAY:
                System.out.println(7);
                yield 7;
            case THURSDAY:
            case SATURDAY:
                System.out.println(8);
                yield 8;
            case WEDNESDAY:
                System.out.println(9);
                yield 9;
            default:
                throw new IllegalStateException("Invalid day: " + day);
        };
        System.out.println(numLetters);

        //ERROR Conditions
        int i = switch (day) {
            case MONDAY -> {
                System.out.println("Monday");
                // ERROR! Block doesn't contain a yield statement
            }
            default -> 1;
        };


        i = switch (day) {
            case MONDAY, TUESDAY, WEDNESDAY:
                yield 0;
            default:
                System.out.println("Second half of the week");
                // ERROR! Group doesn't contain a yield statement
        };

        z:
        for (int i = 0; i < MAX_VALUE; ++i) {
            int k = switch (e) {
                case 0:
                    yield 1;
                case 1:
                    yield 2;
                default:
                    continue z;
                    // ERROR! Illegal jump through a switch expression
            };
            // ...
        }

    }
}
