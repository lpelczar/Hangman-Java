# Hangman in Java

## Requirements

- There is a file Countries and capitals containing list of countries and their capitals (i.e. Poland | Warsaw). Your program should read that file at the beginning and randomly select one capital. The capital is the target word(s) to guess.
- At the beginning program should represent each letter as a dash ("_") and display them on the screen. Additionally, program should show player's life points (10).
- Program asks and waits for the user to enter letter or word. If entered letter doesn't exist in word or entered word is not correct - player will loose a life point. If this action brings player life to zero - the game is over!
- If the player survives wrong letter guess - that letter is added to "not-in-word" list and be displayed at the screen.
- If the player guesses final letter or whole word(s) - he/she is the winner!
- Add a question about starting program once again after user win/loose.
- Add an information about guessing count and guessing time at the end of game (i.e. "You guessed after 12 letters. It took you 45 seconds").
- The country should be also remembered - if player will remain on his/her last life points program should display a hint (i.e. "The capital of Poland").
- Guessing whole word should be more-risk-more-reward. So, successful guess can save some time, but failing whole word guess should result in loosing 2 life points!
- Add high score - everyone like to be proud of his/her successes. At the end of successful game program should ask user for his/her name and save that information to a file - name| date | guessing_time | guessing_tries | guessed_word (i.e. Marcin | 26.10.2016 14:15 | 45 | Warsaw).
- Expand high score - program should remember 10 best scores (read from and write to a file) and display them at the end, after success / failure.
- Add ASCII art! How awesome it will be if after each wrong guess a part of hangman will appear? Or a spaceship will be closer to the Earth? Or something different - use your imagination! :)   

## Sample screenshots

![c1](http://i68.tinypic.com/2s84mjb.png)

## More info

Project made for [Codecool](https://codecool.com/) programming course.
