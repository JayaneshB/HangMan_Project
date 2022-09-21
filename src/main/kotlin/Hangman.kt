import kotlin.random.Random

val words=listOf("India","England","Porsche","Nissan","Cinema","AR Rahman","Aniruth","Yuvan","Udmey")
var track=""
val guesses=arrayListOf<Char>()
var remainingGuesses=6
var mistakes=0


fun main() {
    setupGame()
}

fun setupGame(){
    val wordIndex=Random.nextInt(words.size)
    track=words[wordIndex].toUpperCase()
    println(track)

    for(i in track.indices)
        guesses.add('_')


    var gameOver=false

    do {
        printGameStatus()
        println("Please enter a letter:")
        val input=readLine()?:""

        if(input.isEmpty()) {
            println("Not a valid input. Please try again!")
        }
        else {
            val letter=input[0].toUpperCase()
            if(track.contains(letter)) {
                for( i in track.indices){
                    if(track[i]==letter)
                        guesses[i]=letter
                }
                if(!guesses.contains('_'))
                    gameOver=true
            }
            else {
                println("Sorry that not the part of the word :( ")
                remainingGuesses--
                mistakes++
                if(mistakes==6) {
                    gameOver=true
                }
            }
        }

    }while(!gameOver)

    if(mistakes==6){
        printGameStatus()
        println("Sorry You Lost the Game. The word was \n $track")
    }
    else {
        println("Congratulations, you win !!!")
        println("The word was \n $track")
    }

}

fun printGameStatus() {
    when(mistakes) {
        0 -> print0Mistakes()
        1 -> print1Mistakes()
        2 -> print2Mistakes()
        3 -> print3Mistakes()
        4 -> print4Mistakes()
        5 -> print5Mistakes()
        6 -> print6Mistakes()
    }
    print("Word: ")
    for(i in guesses)
        print("$i ")
    println("\nYou have $remainingGuesses guess(es) left")

}

fun print0Mistakes(){
    println("  |------|-")
    println("  |      | ")
    println("  |        ")
    println("  |        ")
    println("  |        ")
    println("  |        ")
    println(" /|\\      ")
    println("/ | \\     ")
}

fun print1Mistakes() {
    println("  |------|-")
    println("  |      | ")
    println("  |      O ")
    println("  |        ")
    println("  |        ")
    println("  |        ")
    println(" /|\\      ")
    println("/ | \\     ")
}

fun print2Mistakes() {
    println("  |------|-")
    println("  |      | ")
    println("  |      O ")
    println("  |      | ")
    println("  |      | ")
    println("  |        ")
    println(" /|\\      ")
    println("/ | \\     ")
}

fun print3Mistakes() {
    println("  |------|-")
    println("  |      | ")
    println("  |      O ")
    println("  |     /| ")
    println("  |      | ")
    println("  |        ")
    println(" /|\\      ")
    println("/ | \\     ")
}
fun print4Mistakes() {
    println("  |------|-")
    println("  |      | ")
    println("  |      O ")
    println("  |     /|\\ ")
    println("  |      | ")
    println("  |       ")
    println(" /|\\      ")
    println("/ | \\     ")
}
fun print5Mistakes() {
    println("  |------|-")
    println("  |      | ")
    println("  |      O ")
    println("  |     /|\\ ")
    println("  |      | ")
    println("  |     /  ")
    println(" /|\\      ")
    println("/ | \\     ")
}
fun print6Mistakes() {
    println("  |------|-")
    println("  |      | ")
    println("  |      O ")
    println("  |     /|\\ ")
    println("  |      | ")
    println("  |     / \\ ")
    println(" /|\\      ")
    println("/ | \\     ")
}