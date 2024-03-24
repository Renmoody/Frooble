import speech_recognition as sr
import re
from difflib import SequenceMatcher
global exit
global safe_word

exit = False

def process_text(text):
        filtered_text = re.sub(r'[^\w\s]', '', text).lower()
        return filtered_text

def string_similarity(string1, string2):
    # Calculate similarity ratio using SequenceMatcher
    similarity_ratio = SequenceMatcher(None, string1, string2).ratio()
    # Check if similarity ratio is greater than or equal to 0.9
    if similarity_ratio >= 0.9:
        return True
    else:
        return False
#exits the program by flipflopping exit condition
def exit_program():
    global exit
    exit = True
    
#Listens for the safe word/sentance
def listen_for_command():
    recognizer = sr.Recognizer()
    with sr.Microphone() as source:
        print("Listening...")
        audio = recognizer.adjust_for_ambient_noise(source)
        audio = recognizer.listen(source)
    try:
        # Use Google Speech Recognition to transcribe the audio
        text = recognizer.recognize_whisper(audio)
        filtered_text = process_text(text)
        print("You said:", filtered_text)
        process_command(filtered_text)
    except sr.UnknownValueError:
        print("Sorry, could not understand audio.")

def process_command(text):
    # Define keywords or sentences to match
    if string_similarity(safe_word, text):
        print("Alerting Emergency Contacts")
        global exit
        exit = True
        # Perform action to turn on lights
    else:
        print("Safe Word Not Detected")
def set_safe_word():
    global safe_word
    safe_word = process_text(input("Please Enter your safe word/sentance, to change this later, go to settings.\n"))


# Continuously listen for commands
def run():
    while True:
        if (exit):
            print("Program Exiting...")
            break
        else:
            listen_for_command()
            
set_safe_word()
print("Safe Word/Sentance : " + safe_word)
run()