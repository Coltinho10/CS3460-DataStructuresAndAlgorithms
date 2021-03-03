import java.io.*;
import java.util.Scanner;
public class Genomes
{
    static Node[] table;
    static int numelements;
    static int size;
    static int count;
    static int countIndex;
    static int numOfSeqs;
    public Genomes()
    {
        numelements = 0;
        size = 1000;   
        table = new Node[size];

    }
    public static void main(String[] args)
    {
        int length = 0;
        String largestGenome = "";  
        Genomes geno = new Genomes(); 
        Scanner scan = new Scanner(System.in);
            while (scan.hasNextLine())
            {
                String line = scan.nextLine();
                geno.insert(line);
            }
            geno.findAnswer(table);
            for (Node cur = table[numOfSeqs]; cur != null; cur = cur.next)
            {
                count++;
                largestGenome = cur.string;
                length = cur.string.length();
            }
            System.out.println("The longest word that appears multiple times is: " + largestGenome);
            System.out.println("It appears " + count + " times, and its length is " + length);
            scan.close();
    }

    public void insert(String line)
    {
        if (numelements == size) 
        {
            size = (size * 2);
            Node[] table2 = new Node[size];       
            
            for (int i = 0; i < table.length; i++)
            {
                for (Node cur = table[i]; cur != null; cur = cur.next)
                {
                    int hashedGenome = hash(line);
                    table2[hashedGenome] = new Node(line, table[hashedGenome]);
                }
            }
        }
        int hashedGenome = hash(line);
        table[hashedGenome] = new Node(line, table[hashedGenome]);
    }
    
    public static int hash(String k)
    {
        int x = 7;
        int h = 0;
        for (int i = 0; i < k.length(); i++)
        {
            h = ((h * x) + (int) k.charAt(i)) % size;
        }
        return h;
    }

    public void findAnswer(Node[] table)
    {
        int bigIndex = 0;
        int count = 0;
        int countIndex = 0;
        int numOfSeqs = 0;
        for (int i = 0; i < table.length; i++)
        {
            count = 0;
            countIndex = i;
            for (Node cur = table[i]; cur != null; cur = cur.next)
            {
               count++;
            }
            if (numOfSeqs < count)
            {
                Node string1 = table[bigIndex];
                Node string2 = table[countIndex];
                if (string1.string.compareTo(string2.string) >= 1)
                {
                    numOfSeqs = numOfSeqs;
                    bigIndex = bigIndex;
                }
                else
                {
                    numOfSeqs = count;
                    bigIndex = countIndex;
                }
            }
            if (numOfSeqs > count)
            {
                Node string1 = table[bigIndex];
                Node string2 = table[countIndex];
                if (string1.string.compareTo(string2.string) >= 1)
                {
                    numOfSeqs = numOfSeqs;
                    bigIndex = bigIndex;
                }
                else if (string1.string.compareTo(string2.string) <= -1)
                {
                    numOfSeqs = count;
                    bigIndex = countIndex;
                }
            }

        }
    }

}
