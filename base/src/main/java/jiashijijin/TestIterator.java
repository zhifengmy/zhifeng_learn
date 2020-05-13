package jiashijijin;

import java.util.Iterator;

public class TestIterator {

    public static class Value {
        private int value;

        public int get() {
            return value;
        }

        public void set(int v) {
            value = v;
        }
    }

    public static class Values implements Iterable<Value> {
        public Values(int capacity) {
            this.capacity = capacity;
        }

        int count = 1;
        int capacity;
        Value v = new Value();

        public Iterator<Value> iterator() {
            return new Iterator<Value>() {
                public boolean hasNext() {
                    return count <= capacity;
                }

                public Value next() {
                    v.set(count++);
                    return v;
                }

                public void remove() {
                    throw new UnsupportedOperationException();
                }
            };
        }

    }

    public static void main(String[] args) {
        Values vs = new Values(10);
        Value result = null;
        for (Value v : vs) {
            if (result == null) {
                result = v;
                System.out.println(result.toString());

            } else {
                result.set(result.get() + v.get());
                System.out.println(result.toString());

            }
        }

        System.out.println(result.get());
    }
}


