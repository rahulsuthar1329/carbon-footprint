import random

def is_valid_guess(guess: str) -> bool:
    return guess.isdigit() and 1 <= int(guess) <= 100

def get_valid_guess() -> int:
    while True:
        guess = input("Enter a number between 1 and 100: ")
        if is_valid_guess(guess):
            return int(guess)
        print("Invalid input. Please enter a valid number between 1 and 100.")

def play_guessing_game():
    target_number = random.randint(1, 100)
    number_of_guesses = 0
    guessed_correctly = False

    print("Guess a number between 1 and 100!")
    
    while not guessed_correctly:
        guess = get_valid_guess()
        number_of_guesses += 1

        if guess < target_number:
            print("Too low. Try again!")
        elif guess > target_number:
            print("Too high. Try again!")
        else:
            print(f"Congratulations! You guessed the number in {number_of_guesses} attempts.")
            guessed_correctly = True

if __name__ == "__main__":
    play_guessing_game()
