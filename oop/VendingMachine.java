package src.main.java.org.example.oop;


import java.util.ArrayList;
import java.util.List;

interface VendingMachine {
    Product getProduct(String name);

    HotDrinkTemperature getProduct(String name, int volume, int temperature);
}