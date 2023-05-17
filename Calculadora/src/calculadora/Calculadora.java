/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculadora;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author anibal
 */
public class Calculadora implements ActionListener {

    // Criancdo as instancias
    JFrame frame;
    JTextField textfield;
    JButton[] numButtons = new JButton[11];
    JButton[] functionButton = new JButton[11];
    JButton addButton, subButton, mulButton, divButton, equiButton;
    JButton decButton, equButton, delButton, clrButton, factButton, negButton;
    JPanel panel;

    Font myFont = new Font("Ink Free", Font.BOLD, 30);

    double num1 = 0, num2 = 0, result = 0;
    char operador;

    Calculadora() {

        frame = new JFrame("Calculadora");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(myFont);
        textfield.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");
        factButton = new JButton("Factorial");
        negButton = new JButton("(-)");
        equiButton = new JButton("^");

        //Matriz dos botoes
        functionButton[0] = addButton;
        functionButton[1] = subButton;
        functionButton[2] = mulButton;
        functionButton[3] = divButton;
        functionButton[4] = decButton;
        functionButton[5] = equButton;
        functionButton[6] = delButton;
        functionButton[7] = clrButton;
        functionButton[8] = factButton;
        functionButton[9] = negButton;
        functionButton[10] = equiButton;

        //Ira precorrer a Matriz
        for (int i = 0; i < 11; i++) {

            //adciona uma funcao ao botao
            functionButton[i].addActionListener(this);
            functionButton[i].setFont(myFont);
            functionButton[i].setFocusable(true);

        }

        for (int i = 0; i < 10; i++) {

            // instanciando os botoes numericos
            numButtons[i] = new JButton(String.valueOf(i));
            numButtons[i].addActionListener(this);
            numButtons[i].setFont(myFont);
            numButtons[i].setFocusable(true);

        }

        //Posicionando os botoes
        delButton.setBounds(50, 430, 145, 50);
        clrButton.setBounds(205, 430, 145, 50);
        negButton.setBounds(250, 360, 100, 50);
        factButton.setBounds(50, 360, 190, 50);

        //Adcionando um painel para os botes 
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 260);
        panel.setLayout(new GridLayout(5, 5, 11, 11));

        //adcionando os botoes no pinel
        panel.add(numButtons[1]);
        panel.add(numButtons[2]);
        panel.add(numButtons[3]);
        panel.add(addButton);
        panel.add(numButtons[4]);
        panel.add(numButtons[5]);
        panel.add(numButtons[6]);
        panel.add(subButton);
        panel.add(numButtons[7]);
        panel.add(numButtons[8]);
        panel.add(numButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numButtons[0]);

        panel.add(divButton);
        panel.add(equiButton);
        panel.add(equButton);

        //Adcionando os componentes na tela
        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(factButton);
        frame.add(textfield);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        // TODO code application logic here
        Calculadora calc = new Calculadora();

    }

    @Override
    // adcionando funcionalidades dos botoes 
    // verifica se algum botao foi clicado
    public void actionPerformed(ActionEvent ae) {

        // pega o numero digitado
        for (int i = 0; i < 10; i++) {
            if (ae.getSource() == numButtons[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }

        }
        // para numeros decimais 
        if (ae.getSource() == decButton) {
            textfield.setText(textfield.getText().concat("."));

        }
        //para adcao
        if (ae.getSource() == addButton) {

            num1 = Double.parseDouble(textfield.getText());
            operador = '+';
            textfield.setText("");
        }
        // subtracao
        if (ae.getSource() == subButton) {

            num1 = Double.parseDouble(textfield.getText());
            operador = '-';
            textfield.setText("");
        }
        //multiplicacao
        if (ae.getSource() == mulButton) {

            num1 = Double.parseDouble(textfield.getText());
            operador = '*';
            textfield.setText("");
        }
        //divisao
        if (ae.getSource() == divButton) {

            num1 = Double.parseDouble(textfield.getText());
            operador = '/';
            textfield.setText("");
        }
        if (ae.getSource() == equiButton) {

            num1 = Double.parseDouble(textfield.getText());
            operador = '^';
            textfield.setText("");
        }
        //igual
        if (ae.getSource() == equButton) {

            num2 = Double.parseDouble(textfield.getText());

            // para pegar o operador escolhid0
            switch (operador) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
                case '^':
                    result = Math.pow(num1, num2);
                    break;

            }

            textfield.setText(String.valueOf(result));
            num1 = result;
        }
        if (ae.getSource() == clrButton) {
            textfield.setText("");
        }
        //limpar
        if (ae.getSource() == delButton) {

            String string = textfield.getText();
            textfield.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                textfield.setText(textfield.getText() + string.charAt(i));
            }
        }
        //numeros negativos
        if (ae.getSource() == negButton) {

            double temp = Double.parseDouble(textfield.getText());
            temp *= -1;
            textfield.setText(String.valueOf(temp));

        }
        //Fatotial
        if (ae.getSource() == factButton) {

            int s = Integer.parseInt(textfield.getText());
            int t = 1;
            while (s != 0) {
                t *= s;
                s--;
            }
            textfield.setText(String.valueOf(t));

        }

    }

}
