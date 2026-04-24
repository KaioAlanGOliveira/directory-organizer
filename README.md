# Automatic File Organization

## Introduction
This tool provides an automatic file organization system that sorts files into specified directories based on predefined rules. It's designed to help users keep their file systems tidy and manageable.

## Features
- **File Sorting**: Automatically sorts files into folders based on file type, date, or user-defined parameters.
- **Custom Rules**: Users can define rules for how files should be organized.
- **Batch Processing**: Organize multiple files at once.

## Installation
To install the directory organizer, follow these steps:
1. Clone the repository:
   ```bash
   git clone https://github.com/KaioAlanGOliveira/directory-organizer.git
   ```
2. Navigate to the project directory:
   ```bash
   cd directory-organizer
   ```
3. Install the required dependencies:
   ```bash
   npm install
   ```

## Usage
To run the directory organizer, use the following command:
```bash
node organizer.js [options]
```

### Options
- `--source <path>`: Specify the source directory containing files to organize.
- `--destination <path>`: Specify the destination directory to place organized files.
- `--rules <rulesFile>`: Load sorting rules from a specified JSON file.

## Examples
1. Basic usage:
   ```bash
   node organizer.js --source /path/to/source --destination /path/to/destination
   ```
2. Using a rules file:
   ```bash
   node organizer.js --source /path/to/source --destination /path/to/destination --rules rules.json
   ```

## Contributions
Contributions are welcome! Please read the CONTRIBUTING.md file for details on how to contribute to this project.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
