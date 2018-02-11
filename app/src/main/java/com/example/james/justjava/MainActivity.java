/**
 * IMPORTANT: Make sure you are using the correct package name. 
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.james.justjava;



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
int numOfCoffee = 0;
int priceOfCoffee = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText("(\\_/)"+"\n(*.*)"+"\n(\")(\")");

        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numOfCoffee);
    }


    /**
     * This method is called when the order button is clicked.
     *  displayPrice(calcPrice(numOfCoffee,priceOfCoffee));
     */
    public void submitOrder(View view) {

    displayPrice(createOrderSummary());

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int quantity) {

        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + quantity);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(String summary) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText (summary);
    }
    /** decrease the number of coffees */
    public void decrement(View view) {
        numOfCoffee--;
        if (numOfCoffee <= -1) { numOfCoffee = 0;}

        displayQuantity(numOfCoffee);
    }
    /** increase the number of coffees */
    public void increment(View view) {
        numOfCoffee++;
        displayQuantity(numOfCoffee);
    }
    /** build total output string */
    private String createOrderSummary (){
        String total = (NumberFormat.getCurrencyInstance().format((numOfCoffee * priceOfCoffee)));

        CheckBox whipTopping = findViewById(R.id.whip);
        CheckBox chocTopping = findViewById(R.id.choco);

        boolean hasWhip = whipTopping.isChecked();
        boolean hasChoc = chocTopping.isChecked();

        EditText cusName = findViewById(R.id.nameBox);

        String summary = " Name: " + cusName.getText();
        if (hasWhip == true) {summary += "\n Whipped topping added";}
        if (hasChoc == true) {summary += "\n Chocolate topping";}
        summary += "\n Quantity: " + numOfCoffee + "\n Total: "+ total + "\n Thank you";
    return summary;
    }

}

