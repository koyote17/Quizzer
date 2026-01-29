package com.example.quizzer.repository;

import com.example.quizzer.models.Question;

import java.util.ArrayList;
import java.util.List;

public class QuizRepository {

    public static List<Question> getQuestions(String category) {
        List<Question> questions = new ArrayList<>();

        switch (category) {
            case "SPORT":
                questions.add(new Question(
                        "Which country won the FIFA World Cup in 2014?",
                        new String[]{"Argentina", "Germany", "Brazil", "Spain"},
                        1
                ));

                questions.add(new Question(
                        "In tennis, what surface is used at Wimbledon?",
                        new String[]{"Clay", "Grass", "Hard", "Carpet"},
                        0
                ));

                questions.add(new Question(
                        "How many players are on the court for one basketball team during a game?",
                        new String[]{"4", "5", "6", "7"},
                        1
                ));

                questions.add(new Question(
                        "Which sport uses the terms “bogey”, “birdie”, and “eagle”?",
                        new String[]{"Cricket", "Tennis", "Golf", "Baseball"},
                        2
                ));

                questions.add(new Question(
                        "Who holds the record for the most Olympic gold medals?",
                        new String[]{"Usain Bolt", "Mark Spitz", "Larisa Latynina", "Michael Phelps"},
                        3
                ));

                questions.add(new Question(
                        "In which sport would you perform a slam dunk?",
                        new String[]{"Volleyball", "Basketball", "Rugby", "Handball"},
                        1
                ));

                questions.add(new Question(
                        "Which boxer was known as “The Greatest” and “The People’s Champion?",
                        new String[]{"Muhammad Ali", "Mike Tyson", "Joe Frazier", "George Foreman"},
                        0
                ));

                questions.add(new Question(
                        "In Formula 1, what does a yellow flag indicate?",
                        new String[]{"Race stopped", "Overtaking allowed", "Final lap", "Hazard on track – slow down"},
                        3
                ));

                questions.add(new Question(
                        "Which country has won the most Rugby World Cup titles??",
                        new String[]{"New Zealand", "South Africa", "Australia", "England"},
                        0
                ));

                case "HISTORY":
                    questions.add(new Question(
                            "In which year did World War II end?",
                            new String[]{"1944", "1945", "1939", "1942"},
                            1
                    ));

                    questions.add(new Question(
                            "Who was the first President of the United States?",
                            new String[]{"Thomas Jefferson", "Abraham Lincoln", "George Washington", "John Adams"},
                            2
                    ));

                    questions.add(new Question(
                            "Which ancient civilization built the pyramids of Giza?",
                            new String[]{"Romans", "Greeks", "Mayans", "Egyptians"},
                            3
                    ));

                    questions.add(new Question(
                            "What wall divided Berlin from 1961 to 1989?",
                            new String[]{"Iron Curtain", "Western Wall", "Berlin Wall", "Cold War Wall"},
                            2
                    ));

                    questions.add(new Question(
                            "Who was the leader of the Soviet Union during most of World War II?",
                            new String[]{"Joseph Stalin", "Vladimir Lenin", "Leon Trotsky", "Nikita Khrushchev"},
                            0
                    ));

                    questions.add(new Question(
                            "The Renaissance began in which European country?",
                            new String[]{"France", "England", "Spain", "Spain"},
                            3
                    ));

                    questions.add(new Question(
                            "What was the main purpose of the Magna Carta, signed in 1215?",
                            new String[]{"To create a parliament", "To limit the power of the king", "To declare independence", "To start a war"},
                            3
                    ));

                    questions.add(new Question(
                            "Which empire was ruled by Julius Caesar?",
                            new String[]{"Byzantine Empire", "Greek Empire", "Roman Empire", "Persian Empire"},
                            0
                    ));

                    questions.add(new Question(
                            "In which year did World War II end?",
                            new String[]{"", "", "", ""},
                            2
                    ));

                    questions.add(new Question(
                            "What event is considered the start of the French Revolution?",
                            new String[]{"Execution of Louis XVI", "Storming of the Bastille", "Declaration of the Republic", "Reign of Terror"},
                            1
                    ));

                    questions.add(new Question(
                            "Which ancient city was buried by the eruption of Mount Vesuvius in 79 AD?",
                            new String[]{"Troy", "Athens", "Pompeii", "Carthage"},
                            2
                    ));

                case("CITIES"):
                    questions.add(new Question(
                            "What is the capital city of Australia?",
                            new String[]{"Sydney", "Melbourne", "Brisbane", "Canberra"},
                            3
                    ));

                    questions.add(new Question(
                            "Which city is known as “The Big Apple”?",
                            new String[]{"Los Angeles", "Chicago", "New York City", "Boston"},
                            2
                    ));

                    questions.add(new Question(
                            "In which city would you find the Colosseum?",
                            new String[]{"Athens", "Rome", "Paris", "Madrid"},
                            1
                            ));

                    questions.add(new Question(
                            "What European city is famous for its canals and gondolas?",
                            new String[]{"Amsterdam", "Venice", "Bruges", "Copenhagen"},
                            1
                    ));

                    questions.add(new Question(
                            "Which city hosted the 2016 Summer Olympics?",
                            new String[]{"London", "Tokyo", "Beijing", "Rio de Janeiro"},
                            3
                    ));

                    questions.add(new Question(
                            "What is the most populous city in the world by metropolitan area?",
                            new String[]{"Shanghai", "Delhi", "Tokyo", "São Paulo"},
                            2
                    ));

                    questions.add(new Question(
                            "In which city is the headquarters of the European Union primarily located?",
                            new String[]{"Luxembourg", "Strasbourg", "Brussels", "Frankfurt"},
                            2
                    ));

                    questions.add(new Question(
                            "Which Asian city is known for the historic Forbidden City?",
                            new String[]{"Seoul", "Kyoto", "Shanghai", "Beijing"},
                            3
                    ));

                    questions.add(new Question(
                            "What city was formerly known as Constantinople?",
                            new String[]{"Athens", "Istanbul", "Ankara", "Sofia"},
                            1
                    ));

                    questions.add(new Question(
                            "Which city is considered the highest capital city in the world by elevation?",
                            new String[]{"Quito", "Bogotá", "Kathmandu", "La Paz"},
                            3
                    ));

                case ("CARS"):
                    questions.add(new Question(
                            "Which company manufactures the Mustang?",
                            new String[]{"Chevrolet", "Dodge", "Ford", "Chrysler"},
                            2
                    ));

                    questions.add(new Question(
                            "Which car brand uses a prancing horse as its logo?",
                            new String[]{"Lamborghini", "Ferrari", "Porsche", "Alfa Romeo"},
                            1
                    ));

                    questions.add(new Question(
                            "What country is the car manufacturer Volvo associated with?",
                            new String[]{"Germany", "Norway", "Sweden", "Finland"},
                            2
                    ));

                    questions.add(new Question(
                            "What does “SUV” stand for?",
                            new String[]{"Sport Utility Vehicle", "Super Urban Vehicle", "Standard Utility Van", "Street Use Vehicle"},
                            0
                    ));

                    questions.add(new Question(
                            "Which German manufacturer produces the 3 Series?",
                            new String[]{"Audi", "Mercedes-Benz", "Volkswagen", "BMW"},
                            3
                    ));

                        questions.add(new Question(
                                "What company pioneered mass automobile production with the Model T?",
                                new String[]{"General Motors", "Ford", "Chrysler", "Peugeot"},
                                1
                        ));

                        questions.add(new Question(
                                "Which JDM manufacturer is known for the Skyline series?",
                                new String[]{"Toyota", "Honda", "Nissan", "Mitsubishi"},
                                1
                        ));

                        questions.add(new Question(
                                "What is the primary function of a catalytic converter in a car?",
                                new String[]{"Reduce harmful emissions", "Reduce fuel consumption", "Increase engine power", "Cool the engine"},
                                0
                        ));

                        questions.add(new Question(
                                "Which car is currently the fastest on the Nurburgring track?",
                                new String[]{"Chevrolet Corvette ZR1X", "Lamborghini Aventador SVJ", "Mercedes-AMG One", "Porsche 911 GT2 RS"},
                                2
                        ));

                        questions.add(new Question(
                                "What was the name of the only Pole who drove in F1?",
                                new String[]{"Piotr Wiecek", "Krzysztof Holowczyc", "Robert Kubica", "Jakub Przygonski"},
                                2
                        ));

        }
        return questions;
    }
}
