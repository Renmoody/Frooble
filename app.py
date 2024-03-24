from flask import Flask, render_template, request
from main import set_safe_word, run, exit_program

app = Flask(__name__)

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/set_safe_word', methods=['POST'])
def set_safe_word_route():
    set_safe_word()
    return "Safe word set successfully."

@app.route('/run', methods=['POST'])
def run_program():
    run()
    return "Program executed."

@app.route('/exit_program', methods=['POST'])
def exit_program_route():
    exit_program()
    return "Program exited."

if __name__ == '__main__':
    app.run(debug=True)