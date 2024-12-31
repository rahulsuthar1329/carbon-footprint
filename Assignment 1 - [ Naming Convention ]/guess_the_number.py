import random


def is_number_in_range(number):
    if number.isdigit() and 1<= int(number) <=100:
        return True
    else:
        return False


def start_the_game():
    target_number=random.randint(1,100)
    has_number_guessed=False
    guessed_number=input("Guess a number between 1 and 100:")
    number_of_guesses=0
    while not has_number_guessed:
        if not is_number_in_range(guessed_number):
            guessed_number=input("I wont count this one. Please enter a number between 1 to 100: ")
            continue
        else:
            number_of_guesses+=1
            guessed_number=int(guessed_number)

        if guessed_number<target_number:
            guessed_number=input("Too low. Guess again")
        elif guessed_number>target_number:
            guessed_number=input("Too High. Guess again")
        else:
            print("You guessed it in", number_of_guesses, "guesses!")
            has_number_guessed=True


start_the_game()