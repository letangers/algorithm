//#include "seqlist.cpp"
#include "linklist.cpp"
#include <iostream>

using namespace std;

int main(void){
	/*--------------seqlist-------------
	seqlist<int> a(3);
	cout<<"当前长度"<<a.length()<<endl;	
	cout<<"最大长度"<<a.maxlength()<<endl;
	int temp=0;
	a.insert(0,&temp);
	temp=1;
	a.insert(1,&temp);
	temp=2;
	a.insert(2,&temp);
	cout<<"预计输出 0 1 3 2"<<endl;
	int *tempget1=a.get(0);
	temp=1;
	int templocate=a.locate(&temp);
	temp=3;
	a.change(2,&temp);
	int *tempget2=a.get(2);
	a.del(2);
	cout<<*tempget1<<" "<<templocate<<" "<<*tempget2<<" "<<a.length()<<endl;
	-----------------------------------*/
	int temp=0;
	linklist<int> a(&temp);
	cout<<"表长"<<a.length()<<endl;
	node<int> *arg=new node<int>;
	arg->data=1;
	a.insert(1,arg);
	node<int> *ret;
	a.get(0,&ret);
	cout<<ret->data<<" ";
	a.get(1,&ret);
	cout<<ret->data<<endl;
	temp=5;
	a.change(0,&temp);
	a.get(0,&ret);
	cout<<ret->data<<endl;
	a.del(0);
	a.get(0,&ret);
	cout<<ret->data<<endl;
	return 0;
}
