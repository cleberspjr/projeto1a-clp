import java.util.Random;
import java.io.BufferedWriter; 
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
  int linhas = 1024;
  int colunas = 100;
  
  public static void insertionSort(int array[]) {
    int size = array.length;

    for (int step = 1; step < size; step++) {
      int key = array[step];
      int j = step - 1;
      
      while (j >= 0 && key < array[j]) {
        array[j + 1] = array[j];
        --j;
      }
      array[j + 1] = key;
    }
  }
  void amostra(int [][] matriz, Random num) {
    try{
      BufferedWriter writer = new BufferedWriter(new FileWriter("amostraJava.txt"));
		  for(int i = 0; i<linhas; i++ ) {
			for(int j = 0; j<colunas; j++) {
				matriz[i][j] = num.nextInt(10);
                writer.write(matriz[i][j]);
			}
		}
        writer.close();
    }
	 catch (IOException e) {
      e.printStackTrace();
   }
  }
  
  public static void main(String[] args) {
    Main ctrl = new Main();
    int [][]m = new int[ctrl.linhas][ctrl.colunas];
    Random rnd = new Random();
    long time;

    try{
      BufferedWriter writer = new BufferedWriter(new FileWriter("ProcessamentoJava.txt"));
    
      for(int z=0; z<ctrl.linhas; z++){
  
        
        for(int i=0; i<ctrl.linhas; i++){
          for(int j=0; j<ctrl.colunas; j++){
            m[i][j] = rnd.nextInt(1000);
          }
        }

        long start = System.currentTimeMillis(); 
        for(int i=0; i<ctrl.linhas; i++){
          ctrl.insertionSort(m[i]);
        }
  
        long end = System.currentTimeMillis();
        time = end - start;
        writer.write(time + "\n");
      }
    writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    
  }
}
