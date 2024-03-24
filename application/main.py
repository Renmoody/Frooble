import re
import speech_recognition as sr
from difflib import SequenceMatcher

recognizer = sr.Recognizer()
exit = False
safe_word = "default phrase set new phrase"

def process_text(text):
        filtered_text = re.sub(r'[^\w\s]', '', text).lower()
        return filtered_text
    
def compare(string1, string2):
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

#Listens for the safe word/sentance - modified from AI generated example
def listen_for_phrase():
    with sr.Microphone() as source:
        print("Listening...")
        audio = recognizer.adjust_for_ambient_noise(source)
        audio = recognizer.listen(source)
    try:
        # Use Google Speech Recognition to transcribe the audio
        text = recognizer.recognize_whisper(audio)
        filtered_text = process_text(text)
        if "thank you" == filtered_text:
            return
        process_command(filtered_text)
    except sr.UnknownValueError:
        print("Sorry, could not understand audio.")
        

def process_command(text):
    # Define keywords or sentences to match
    if safe_word in text:
        
        print("Alerting Emergency Contacts")
        global exit
        exit = True
    split_text = text.split(" ")
    split_safe = safe_word.split(" ")
    x = 0
    errorCount = 0
    #return true if safe words are in the correct order in the text with a 90% accuracy
    #only permit a margin of two words for error in between the safe word detection
    for i in split_text:
        if x == len(split_safe) - 1:
            print("Alerting Emergency Contacts...")
            exit = True
            return
        if errorCount == 3:
            print("Restarting search...")
            x = 0
            errorCount = 0
        if compare(i, split_safe[x]):
            x+=1
            errorCount = 0
        else:
            errorCount+=1
    
#Getters and setters for safe phrase
def set_safe_word():
    global safe_word
    safe_word = process_text(input("Please enter your safe phrase, a minimum number of four words is required to reduce false readings. To change this later, go to settings.\n"))
    if (safe_word.count(" ") < 3):
        safe_word = process_text(input("Please enter a phrase with a minumum of four words.\n"))
def get_safe_word():
    return safe_word


# Continuously listen for commands
def run():   
    while True:
        if (exit):
            print("Program Exiting...")
            return True
        else:
            try:
                listen_for_phrase()
            except KeyboardInterrupt:  # Catch Ctrl+C interrupts to exit
                print("KeyboardInterrupt...")
                break
    return False

set_safe_word()
run()