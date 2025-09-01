const readline = require("readline");

// Get all supported timezones from Intl API
const timezones = Intl.supportedValuesOf("timeZone");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

// Show first 50 timezones so terminal isn’t overloaded
console.log("Select a timezone (showing first 50 of " + timezones.length + "):\n");
timezones.forEach((tz, index) => {
  console.log(`${index + 1}. ${tz}`);
});

rl.question("\nEnter the number of the timezone you want: ", function(choice) {
    const index = parseInt(choice, 10) - 1;

    if (index >= 0 && index < timezones.length) {
        let timezone = timezones[index];

        let formatter = new Intl.DateTimeFormat("en-US", {
            timeZone: timezone,
            timeStyle: "medium",
            dateStyle: "long"
        });

        let currentTime = formatter.format(new Date());

        console.log(`\nCurrent time in ${timezone} is:\n${currentTime}`);
    } else {
        console.log("❌ Invalid choice! Please run again and pick a valid number.");
    }

    rl.close();
});
