


/*
struct Node
{
	int data;
	struct Node *next;
	
	Node(int x){
	    data =x;
	    next = NULL;
	}
};
*/

class Solution
{
public:
    void reverse(Node** head) {
        Node* prev = nullptr;
        Node* current = *head;
        Node* next = nullptr;
        while (current != nullptr) {
            next = current->next;
            current->next = prev;
            prev = current;
            current = next;
        }
        *head = prev;
    }

    void sort(Node **head)
    {
        if (*head == nullptr || (*head)->next == nullptr) // Check if the list is empty or has only one node
            return;

        Node *odd = *head;
        Node *even = (*head)->next;
        Node* evenhead = (*head)->next;
        while(even != nullptr && even->next != nullptr){
            odd->next = odd->next->next;
            even->next = even->next->next;
            odd = odd->next;
            even = even->next;
        }
        reverse(&evenhead);
        odd->next = evenhead;
    }
};
