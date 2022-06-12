#include <stdio.h>
long long int MAX(long long int a,long long int b){
    return a>b?a:b;
}
int main(){
    int testnum=0;
    int n;
    int tmp=0;
    long long int sum=0;
    int scorearr[100001][2]={};
    long long int casescore[100001][2]={};
    scanf("%d",&testnum);
    for(int i=0;i<testnum;i++)
    {
        scanf("%d",&n);
        for(int k=0;k<2;k++){
        for(int j=0;j<n-1;j++)
            scanf("%d ",&scorearr[j][k]);
        scanf("%d",&scorearr[n-1][k]);
        }//입력
        casescore[0][0]=scorearr[0][0];
        casescore[0][1]=scorearr[0][1];//initiation
        casescore[1][0]=casescore[0][1]+scorearr[1][0];
        casescore[1][1]=casescore[0][0]+scorearr[1][1];
        for(int k=2;k<n;k++){
            casescore[k][0]=MAX((MAX(casescore[k-2][0],casescore[k-2][1])+scorearr[k][0]),casescore[k-1][1]+scorearr[k][0]);
            casescore[k][1]=MAX((MAX(casescore[k-2][0],casescore[k-2][1])+scorearr[k][1]),casescore[k-1][0]+scorearr[k][1]);
        //printf("%lld %lld\n",casescore[k][0],casescore[k][1]);
        }
    printf("%lld\n",MAX(casescore[n-1][0],casescore[n-1][1]));
    }
}
