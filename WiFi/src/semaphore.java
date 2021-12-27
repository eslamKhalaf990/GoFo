class semaphore {
    int limit;
    public semaphore(int limit){
        this.limit = limit;
    }
    public synchronized void reserve() {
        limit--;
        if (limit < 0) {
            try {
                wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void release() {
        limit++;
        if (limit <= 0)
            notify();
    }
}

