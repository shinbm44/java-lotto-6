package inputprocess;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {

    private final List<Integer> numbers;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Lotto(String numberString) {
        String [] number = CheckNumber(numberString);
        List<Integer> numbers = ChangeToInteger(numberString);
        this.numbers = numbers;
    }

    private  List<Integer> ChangeToInteger(String numberString){
        String[] changeToNumber = numberString.split(",");
        List<String> changeToNumber2 = Arrays.stream(changeToNumber).collect(Collectors.toList());
        List<Integer> LottoNumber = changeToNumber2.stream()
                                             .map(s -> Integer.parseInt(s))
                                             .collect(Collectors.toList());
        return LottoNumber;
    }

    private String[] CheckNumber(String numberString) {
        String[] numberList = numberString.split(",");
        inspectNumber(numberList);
        return numberList;
    }

    private void inspectNumber(String[] numberList) {
        validInputSting(numberList);
    }

    private void validInputSting(String[] numberList) {
        int len = numberList.length;

        while(true){
            try{
                checklenth(len);
                checkAllIntegers(numberList);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] ','로 구분한 6개의 정수를 입력해주세요.");
                String newInput = Console.readLine();
                numberList = newInput.split(",");
                len = numberList.length;
            }

        }
    }

    private void checklenth(int len) throws IllegalArgumentException {
        if (len != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void checkAllIntegers(String[] numberString) {
        for (String s : numberString) {
            if(!isInteger(s)){
                throw new IllegalArgumentException();
            }
        }

    }

    private boolean isInteger(String s) {
        try {
            int x = Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }
}