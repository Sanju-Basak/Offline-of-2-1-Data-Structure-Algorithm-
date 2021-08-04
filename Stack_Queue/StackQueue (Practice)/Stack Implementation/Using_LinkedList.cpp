#include<iostream>
#include<string>

using namespace std;

class Node
{
public:
    string str;
    Node *next;
};

class Stack
{
    Node *head= NULL;
public:
    void push(string str)
    {
        Node *node= new Node();
        node->str= str;
        node->next= head;
        head= node;
    }
    string pop()
    {
        if(!isEmpty())
        {
            string str1= head->str;
            head= head->next;
            return str1;
        }
        else
            return "Stack is Empty!!";

    }
    string top()
    {
        if(!isEmpty())
        {
            return head->str;
        }
        else
            return "Stack is Empty!!";
    }

    bool isEmpty()
    {
        return head==NULL;
    }
};

int main()
{
   Stack stk;
   stk.push("you!");
   stk.push("love");
   stk.push("I");
   cout<< stk.pop()<< " ";
   cout<< stk.pop()<< " ";
   cout<< stk.pop()<< " ";
}

