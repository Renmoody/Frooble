import tkinter as tk

# Create the main window
#root = tk.Tk()
#root.title("Fruble GUI")

# Create a label widget
#label = tk.Label(root, text="Fruble")
#label.pack()

# Run the main event loop
# root.mainloop()
def open_new_window():
    # Function to open a new window
    new_window = tk.Toplevel(root)
    new_window.title("New Window")
    new_window.geometry("400x300")  # Set the size of the new window
    label = tk.Label(new_window, text="Contacts")
    label.pack()

root = tk.Tk()
root.title("Home")
root_label = tk.Label(root, text="Fruble", font=("Arial", 25))

root.geometry("600x400")
root_label.pack()


# Create a button to open the new window
button = tk.Button(root, text="Contacts", command=open_new_window, font=("Arial", 25))
button.pack()

root.mainloop()