#include <iostream>

using namespace std;

template <typename T>
class seqlist
{
private:
	int mxlength;
	int last;
	T *data;
public:
	seqlist(int length){
		mxlength=length;
		last=-1;
		data=new T[mxlength];

	}
	~seqlist(){
		delete data;
	}
	int maxlength(){ return mxlength;}
	int length(){ return last+1;}
	T* get(int i){
		//获取位置i的元素，成功返回该元素指针，失败返回空指针
		if(i>last)
			return NULL;
		return &data[i];
	}
	int locate(const T* x){
		//获取第一个值为x指向内容的下标，不存在返回-1
		//需要T类型实现赋值运算符
		for (int i=0;i<=last;i++){
			if (data[i]==*x)
				return i;
		}
		return -1;
	}
	int insert(int i,const T* x){
		//向下标i位置插入x，若失败返回-1，成功返回0
		if(i>last+1|| last==mxlength)
			return -1;
		for(int index=last+1;index>i;index--)
			data[index]=data[index-1];
		data[i]=*x;
		last++;
		return 0;
	}
	int change(int i,const T* x){
		//改变下标i位置的值为 *x，失败返回-1，成功返回0
		if(i>last)
			return -1;
		data[i]=*x;
		return 0;
	}
	int del(int i){
		//删除下标为i的值，失败返回-1，成功返回0
		if(i>last)
			return -1;
		if(i!=last)
			for(int index=i;index<=last;index++)
				data[index]=data[index+1];
		last--;
		return 0;
	}
};

