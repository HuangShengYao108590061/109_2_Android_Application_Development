package com.example.android.a108590061_hw5_part_1;

public class Calculator {

    public enum OPRT {
        ADDITION,
        SUBTRACT,
        DIVISION,
        MULTIPLY,
        POWER
    }

    public double Additions(double FirstOpInput, double SecOpInput) {

        return FirstOpInput + SecOpInput;

    }

    public double Subtractions(double FirstOpInput, double SecOpInput) {

        return FirstOpInput - SecOpInput;

    }

    public double Multiplications(double FirstOpInput, double SecOpInput) {

        return FirstOpInput * SecOpInput;

    }

    public double Divisions(double FirstOpInput, double SecOpInput) {
        if (SecOpInput == 0 ) {

            throw new IllegalArgumentException("Can't divide by zero");

        }

        return FirstOpInput / SecOpInput;

    }

    public double Powers(double FirstOpInput, double SecOpInput) {

        return Math.pow(FirstOpInput,SecOpInput);

    }

}