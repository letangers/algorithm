#include <iostream>

using namespace std;

template <typename T>
struct node{
	T data;
	struct node * next;
};


template <typename T>
class linklist
{
private:
	node<T> * head;
	int len;
public:
	linklist(const T* arg){
		head=new node<T>;
		head->data=*arg;
		head->next=NULL;
		len=1;
	}
	int length(){
		//求表长,一般需要遍历
	        return len;
	}
	int insert(int i,node<T> *arg){
		//从第i位置插入arg，i从0开始
		//成功返回0，失败返回-1
		if(i>len||i<0)
			return -1;
		len++;
		if(i==0){
			arg->next=head;
			head=arg;
			return 0;
		}
		node<T> *temp=head;
		for(int j=1;j<i;j++)
			temp=temp->next;
		arg->next=temp->next;
		temp->next=arg;
		return 0;
	}
	int get(int i,node<T> ** ret){
		//获取i位置的值，i从0开始
		if(i>=len||i<0)
			return -1;
		node<T> *temp=head;
		for(int j=0;j<i;j++)
			temp=temp->next;
		*ret=temp;
		return 0;
	}
	int change(int i,const T* arg){
		//更改i位置的值，i从0开始
		if(i>=len||i<0)
			return -1;
		node<T> *temp =head;
		for (int j=0;j<i;j++)
			temp=temp->next;
		temp->data=*arg;
		return 0;
	}
	int del(int i){
		//删除i位置的值，i从0开始
		if(i>=len||i<0)
			return -1;
		node<T> * d;
		if(i==0){
			d=head;
			head=head->next;
		}
		else{
			node<T> *temp=head;
			for(int j=1;j<i;j++)
				temp=temp->next;
			d=temp;
			temp=temp->next;
		}
		delete d;
		return 0;
	}
};
