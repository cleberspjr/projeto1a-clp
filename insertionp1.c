#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define col 100
#define lin 1024

void insertionSort(int array[], int size) {
  int step;
  for (step = 1; step < size; step++) {
    int key = array[step];
    int j = step - 1;

    while (key < array[j] && j >= 0) {
      array[j + 1] = array[j];
      --j;
    }
    array[j + 1] = key;
  }
}

void amostra(int m[][col]){
  FILE *fp;
  fp = fopen("time.txt", "w");
  if(fp == NULL){
    printf("Erro ao abrir o arquivo!!!");
    exit(-1);
  }

  for(int i = 0; i < lin; i++){
    for(int j = 0; j < col; j++){
      m[i][j] = rand() % 1000;
      fprintf(fp, "%d ", m[i][j]);
    }
    fprintf(fp, "\n");
  }
  fclose(fp);

}

int main(){

  int m[lin][col];
  double time_spent;
  clock_t start_t, end_t; 
  
  srand(time(NULL));
  for(int i = 0; i < lin; i++){
  amostra(m);

    FILE *f;
    f = fopen("tempoProcessamento.txt", "a");
    if(f == NULL){
      printf("Erro ao abrir o arquivo!!!");
      exit(-1);
    }

        start_t = clock();

        for(int i = 0; i < lin; i++){
            insertionSort(m[i], col);
        }
        end_t = clock();
        time_spent = (double)(end_t - start_t) / CLOCKS_PER_SEC;
        fprintf(f, "%f \n", time_spent);
    

    fclose(f);
  }

    return 0;
}