package Generate_Test_Case;

import java.io.*;
import java.util.*;

public class GenerateTestCase {

    public static void main(String[] args) throws IOException {

        List<Variable> variables = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfVariable = br.read()-'0';
        br.read();
        HashMap<Character, Integer> representVal = new HashMap<>(numberOfVariable);
        StringTokenizer st;
        for (int i = 0; i < numberOfVariable; i++) {
            st = new StringTokenizer(br.readLine(), "/");
            char name = st.nextToken().charAt(0);
            char type = st.nextToken().charAt(0);
            int min = Integer.parseInt(st.nextToken());
            int max = Integer.parseInt(st.nextToken());
            char repetitive = st.nextToken().charAt(0);
            char separator = st.nextToken().charAt(0);
            char duplicate = st.nextToken().charAt(0);

            Variable newVar = new Variable(name,type,min,max,repetitive,separator,duplicate);
            variables.add(newVar);
        }
        generateTestCases("test.txt", variables, representVal);
    }

    public static void generateTestCases(String fileName, List<Variable> variables, HashMap<Character, Integer> representVal) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Variable variable : variables) {

                int repeatCount;
                if (variable.repetitive == '0') {
                    repeatCount = 1;
                } else {
                    repeatCount = representVal.get(variable.repetitive);
                }

                Set<Integer> generated = new HashSet<>();

                while (generated.size() != repeatCount) {
                    int value = generateRandomInt(variable.min, variable.max);
                    generated.add(value);
                    representVal.put(variable.name, value);
                }
                for (Integer val : generated) {
                    writer.write(val + variable.separator);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int generateRandomInt(int min, int max) {

        Random rand = new Random();
        int result = rand.nextInt(max - min + 1) + min;
        return result;
    }
}
class Variable {
    char name;
    char type;
    int min;
    int max;
    char repetitive;    // '0'이면 반복 x, 아니면 반복 o 반복수는 name.charAt(0)에게 종속됨
    char separator;
    boolean duplicate;

    public Variable(char name, char type, int min, int max, char repetitive, char separator, char duplicate) {
        this.name = name;
        this.type = type;
        this.min = min;
        this.max = max;
        this.repetitive = repetitive;
        this.separator = separator;
        this.duplicate = (duplicate == '1');
    }
}
