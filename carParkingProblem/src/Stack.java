public class Stack {
    Object[] data;
    private int size;
    private int top;

    //初始化一个栈
    public Stack(int size) {
        this.size = size;
        data = new Object[size];
        top = -1;
    }

    //得到栈的长度
    public int getSize() {
        return size;
    }

    public int getTop() {
        return top;
    }

    //判断栈是否为空栈
    public boolean isEmpty() {
        return top == -1;
    }

    //判断栈是否为满栈
    public boolean isFull() {
        return (top + 1) == size;
    }

    //压栈
    public boolean push(Object data) {
        if (isFull()) {
            System.out.println("the stack is full");
            return false;
        } else {
            top++;
            this.data[top] = data;
            return true;
        }
    }
    //弹栈

    public Object pop() throws Exception{
        if(isEmpty()){
            throw new Exception("the stack is empty");

        }else{
            return this.data[top--];
        }
    }
    //获取栈顶的元素，但是不弹栈
    public Object peek(){
        return this.data[getTop()];
    }
}
