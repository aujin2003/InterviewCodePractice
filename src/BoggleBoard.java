import java.util.*;

public class BoggleBoard{

  Map<Integer, Map<String, ArrayList<Integer>>> boggleBoard = new HashMap<Integer, Map<String, ArrayList<Integer>>>();
  Map<String, ArrayList<Integer>> startBoard = new HashMap<String, ArrayList<Integer>>();

  public BoggleBoard(String[][] board){
    System.out.println(Arrays.toString(board));
    init(board);
    System.out.println("SAND: " + isLetterValid("SAND"));
    System.out.println("STAR: " + isLetterValid("STAR"));
    System.out.println("NOTE: " + isLetterValid("NOTE"));
    System.out.println("TONE: " + isLetterValid("TONE"));
  }

  public boolean isLetterValid(String letter){

    ArrayList<Integer> startIds = startBoard.get(Character.toString(letter.charAt(0)));

    boolean isValid = false;
    for(int id: startIds){
      if(!isValid)
        isValid = isLetterValid(letter, 0, id);
    }

    return isValid;
  }

  public boolean isLetterValid(String letter, int index, int chId){


      if(!boggleBoard.containsKey(chId)){
        return false;
      }

      if(index >= letter.length() - 1)
        return true;


    String nextLetter = Character.toString(letter.charAt(index + 1));

      if(boggleBoard.get(chId).containsKey(nextLetter)){

        ArrayList<Integer> chIds = boggleBoard.get(chId).get(nextLetter);

        boolean isValid = false;

        for(int id: chIds){
          if(isValid == false)
            isValid = isLetterValid(letter, index + 1, id);
        }

        return isValid;
      }else{
        return false;
      }


  }

  public void init(String[][] board){

    int keyIndex = 0;

    for(int i = 0; i < board.length; i++){
      for(int j = 0; j < board.length; j++){

        if(!startBoard.containsKey(board[i][j])){
          startBoard.put(board[i][j], new ArrayList<Integer>());
        }

        startBoard.get(board[i][j]).add((i * board.length) + j);

        Map<String, ArrayList<Integer>> value = new HashMap<String, ArrayList<Integer>>();
        System.out.println("adding values to " + board[i][j] + " " + ((i * board.length) + j));


        for(int x = -1; x < 2; x++){
          for(int y = -1; y < 2; y++){
            if(!(x == 0 && y == 0)){
              if(i + x >= 0 && i + x < board.length && j + y >= 0 && j + y < board.length){
                String key = board[i + x][j + y];
                if(!value.containsKey(key)){
                  value.put(key, new ArrayList<Integer>());
                }
                ArrayList<Integer> v = value.get(key);
                v.add( (( i  + x )* board.length) + j + y);

                System.out.println("adding key " + key + " and value: " + v.toString());
              }
            }
          }
        }

        boggleBoard.put((i * board.length) + j, value);

      }
    }
  }

}