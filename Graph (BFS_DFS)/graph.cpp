#include<iostream>
#include<cstdio>
#include<queue>
#include<stack>
#include<fstream>

using namespace std;

int bfs(vector <int> adj[], vector <int> &pieces, int node, int source)
{
    int collected= 0, x;
    bool marked[node];
    for(int i=0; i< node; i++)
        marked[i]= false;
    queue<int> que;
    que.push(source);
    marked[source]= true;
    while(!que.empty())
    {
        x= que.front();
        if(pieces[x]>0)
        {
            collected= collected+ pieces[x];
            pieces[x]=0;
        }
        que.pop();
        for(int i=0; i< adj[x].size(); i++)
        {
            int y= adj[x][i];
            if(!marked[y])
            {
                que.push(y);
                marked[y]= true;
            }
        }
    }
    return collected;
}

int dfs(vector <int> adj[], vector <int> &pieces, int node, int source)
{
    int collected= 0, x;
    bool marked[node];
    for(int i=0; i< node; i++)
        marked[i]= false;
    stack<int> stk;
    stk.push(source);
    marked[source]= true;
    while(!stk.empty())
    {
        x= stk.top();
        if(pieces[x]>0)
        {
            collected= collected+ pieces[x];
            pieces[x]=0;
        }
        stk.pop();
        for(int i=0; i< adj[x].size(); i++)
        {
            int y= adj[x][i];
            if(!marked[y])
            {
                stk.push(y);
                marked[y]= true;
            }
        }
    }
    return collected;
}



int main()
{
    int city, road, location, fri;
    int total= 0;
    int no_collected= 0;
    cin>> city>> road>> location>> fri;
    vector <int> adj[city];
    vector <int> pieces(city, 0);///need to collect
    vector <int> collect[fri];///collected individually

    ///inputs road
    for(int i= 0; i< road; i++)
    {
        int c1,c2;
        cin>> c1>> c2;
        adj[c1].push_back(c2);
        adj[c2].push_back(c1);
    }
    ///inputs pieces
    for(int i=0; i< location; i++)
    {
        int cx, px;
        cin>> cx>> px;
        pieces[cx]= px;
        total= total+ px;
    }
    ///inputs friends location
    for(int i=0; i< fri; i++)
    {
        int cy, fy;
        cin>> cy>> fy;
        collect[fy].push_back(cy);

    }

    ///BFS
    vector <int> temp_pieces(city, 0);
    temp_pieces= pieces;
    for(int i=0; i< fri; i++)
    {
        collect[i].push_back(bfs(adj, temp_pieces, city, collect[i][0]));
        no_collected= no_collected+ collect[i][1];
    }
    ofstream bfsfile ("BFS_Output.txt");
    if(no_collected== total)
        bfsfile<< "Mission Accomplished\n";
    else
        bfsfile<< "Mission Impossible\n";
    bfsfile<< no_collected<< " out of "<< total<< " pieces are collected\n";
    for(int i=0; i<fri; i++)
        bfsfile<< i<< " collected "<< collect[i][1]<< " pieces\n";


    ///DFS
    no_collected= 0;
    for(int i=0; i< fri; i++)
    {
        collect[i].push_back(dfs(adj, pieces, city, collect[i][0]));
        no_collected= no_collected+ collect[i][2];
    }
    ofstream dfsfile ("DFS_Output.txt");
        if(no_collected== total)
        dfsfile<< "Mission Accomplished\n";
    else
        dfsfile<< "Mission Impossible\n";
    dfsfile<< no_collected<< " out of "<< total<< " pieces are collected\n";
    for(int i=0; i<fri; i++)
        dfsfile<< i<< " collected "<< collect[i][2]<< " pieces\n";


}

