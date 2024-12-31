def check_armstrong(number):
    sum_of_powers = 0
    digit_count = 0

    temporary_number = number
    while temporary_number > 0:
        digit_count = digit_count + 1
        temporary_number = temporary_number // 10

    temporary_number = number
    for _ in range(1, temporary_number + 1):
        remainder = temporary_number % 10
        sum_of_powers = sum_of_powers + (remainder ** digit_count)
        temporary_number //= 10
    return sum_of_powers


user_input = int(input("\nPlease Enter the Number to Check for Armstrong: "))

if (user_input == check_armstrong(user_input)):
    print("\n %d is Armstrong Number.\n" % user_input)
else:
    print("\n %d is Not a Armstrong Number.\n" % user_input)