#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <unistd.h>

int main() {
    key_t key = ftok("shmfile", 65);  // Create unique key
    int shmid = shmget(key, 1024, 0666 | IPC_CREAT);  // Create segment

    char *str = (char *)shmat(shmid, NULL, 0);  // Attach to memory

    strcpy(str, "Hello from System V Shared Memory!");
    printf("Writer wrote: %s\n", str);

    shmdt(str);  // Detach
    return 0;
}
