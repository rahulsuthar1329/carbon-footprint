using System;
using System.Numerics;

class FloorOfMean
{
    static void Main(string[] args)
    {
        var inputNumbers = ReadArrayAndQueryCount();
        var numbers = ReadArray();
        long[] prefixSumArray = ComputePrefixSum(numbers);

        ProcessQueries(inputNumbers[1], prefixSumArray);
    }

    static int[] ReadArrayAndQueryCount()
    {
        return Array.ConvertAll(Console.ReadLine().Split(' '), int.Parse);
    }

    static long[] ReadArray()
    {
        return Array.ConvertAll(Console.ReadLine().Split(' '), long.Parse);
    }

    static long[] ComputePrefixSum(long[] numbers)
    {
        long[] prefixSumArray = new long[numbers.Length + 1];
        for (int index = 1; index <= numbers.Length; index++)
        {
            prefixSumArray[index] = prefixSumArray[index - 1] + numbers[index - 1];
        }
        return prefixSumArray;
    }

    static void ProcessQueries(int queryCount, long[] prefixSumArray)
    {
        for (int queryIndex = 0; queryIndex < queryCount; queryIndex++)
        {
            var range = ReadArrayAndQueryCount();
            Console.WriteLine(CalculateRangeAverage(prefixSumArray, range[0], range[1]));
        }
    }

    static long CalculateRangeAverage(long[] prefixSumArray, int start, int end)
    {
        return (prefixSumArray[end] - prefixSumArray[start - 1]) / (end - start + 1);
    }
}
