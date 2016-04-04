package Listas;

import java.lang.reflect.Array;

public class QueueArray<T> {
    private T[] _queue;
    private int _queuesize;
    private int _index;
    private int _tail;
    private boolean _flag;
    
    public QueueArray (Class<T> c, int pSize){
        _queue = (T[]) Array.newInstance(c, pSize); //new T[pSize];
        _queuesize = pSize;
        _index = 0 ;
        _tail = 0 ; 
        _flag = true;
    }
    
    public boolean isFull(){
        return (_flag && (_index == 0 && _tail == _queuesize)) ||
                (!_flag && _index == _tail);        
    }
    
    public boolean isEmpty(){
        return ((_index == _tail) && _flag);
    }
    
    private void resize(){
        int newsize = (_queuesize / 2) + _queuesize;
        T[] newqueue;
        newqueue = new T[newsize];
        int j = _index;
        
        for(int i = 0;+ i < _queuesize ; i++ , j++){
            if(j == _queuesize)
                j = 0;
            newqueue[i] = _queue[j];   
        }
        
        _flag = true;
        _index = 0;
        _tail = _queuesize;
        _queuesize = newsize;
        _queue = newqueue;
    }
    
    public void enqueue (T pDato){
        if(isFull()){
            resize();
        }
        
        if(_tail == _queuesize && _index != 0){
            _tail = 0;
            _flag = false;
        }
        
        _queue[_tail] = pDato;
        
    }
    
    public T dequeue(){
        if(isEmpty())
            return ;
        
        if(_index == _queuesize){
            _flag = true;
            _index = 0;
        }
        
        return _queue[index++]; 
    }
    
}