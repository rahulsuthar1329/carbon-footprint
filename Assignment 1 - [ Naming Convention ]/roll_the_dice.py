import random


def roll_the_dice(max_dice_range):
    dice_number=random.randint(1, max_dice_range)
    return dice_number


def start_the_game():
    max_dice_range=6
    should_play=True
    while should_play:
        player_choice=input("Ready to roll? Enter Q to Quit: ")
        if player_choice.lower() !="q":
            dice_number=roll_the_dice(max_dice_range)
            print("You have rolled a", dice_number)
        else:
            should_play=False


start_the_game()