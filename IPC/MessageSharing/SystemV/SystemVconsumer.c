#include <stdio.h>
#include <stdlib.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <unistd.h>

int main() {
    key_t key = ftok("shmfile", 65);  // Same key
    int shmid = shmget(key, 1024, 0666);  // Get segment

    char *str = (char *)shmat(shmid, NULL, 0);  // Attach
    printf("Reader read: %s\n", str);

    shmdt(str);  // Detach
    shmctl(shmid, IPC_RMID, NULL);  // Delete memory
    return 0;
}



/*
ftok()-	Generate a unique key for shared memory
shmget()-	Create/get a shared memory segment
shmat()-	Attach shared memory to process
shmdt()-	Detach shared memory
shmctl()-	Control shared memory (e.g., delete it)

*/


/*
How to run 
touch shmfile
gcc producer.c -o producer
gcc consumer.c -o consumer
Terminal 1: ./consumer

Terminal 2: ./producer


*/