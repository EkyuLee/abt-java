package com.semiboard.dependencyexample;

//weak coupling and weak dependency
public class ChoiceFood {
    void eat(Food food){
        food.eat();
    }
    public static void main(String[] args) {
        ChoiceFood choiceFood = new ChoiceFood();
        choiceFood.eat(new Chicken());
        choiceFood.eat(new Pizza());
        choiceFood.eat(new Burger());
    }
}

//object injection example
class ChoiceFood2{
    Food food;
    void eat(){ // 객체를 주입 후 실행할 method
        this.food.eat();
    }

    public static void main(String[] args) {
        ChoiceFood2 choiceFood = new ChoiceFood2();
        choiceFood.food = new Chicken(); //객체 주입
        choiceFood.eat();

        choiceFood.food = new Pizza();
        choiceFood.eat();

        choiceFood.food = new Burger();
        choiceFood.eat();
    }
}

// injection using method
class ChoiceFood3{
    Food food;
    void eat(){
        this.food.eat();
    }
    void setFood(Food food){
        this.food = food;
    }
    public static void main(String[] args) {
        ChoiceFood3 choiceFood = new ChoiceFood3();
        choiceFood.setFood(new Chicken());
        choiceFood.eat();

        choiceFood.setFood(new Pizza());
        choiceFood.eat();

        choiceFood.setFood(new Burger());
        choiceFood.eat();
    }
}

//injection using constructor
class ChoiceFood4{
    Food food;
    public ChoiceFood4(Food food){
        this.food = food;
    }
    void eat(){
        this.food.eat();
    }

    public static void main(String[] args) {
        ChoiceFood4 choiceFood4 = new ChoiceFood4(new Chicken());
        choiceFood4.eat();

        choiceFood4 = new ChoiceFood4(new Pizza());
        choiceFood4.eat();

        choiceFood4 = new ChoiceFood4(new Burger());
        choiceFood4.eat();
    }
}

class ChoiceFood5{

}


