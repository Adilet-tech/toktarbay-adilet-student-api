
#!/bin/bash

STUDENT="Adilet Toktarbay"
LOG_FILE="logs/Toktarbay_Adilet_system_report.log"

{
    echo "=================================="
    echo "       SYSTEM REPORT"
    echo "=================================="

    echo "Student: $STUDENT"

    echo ""
    echo "DATE AND TIME:"
    date

    echo ""
    echo "CURRENT USER:"
    whoami

    echo ""
    echo "OPERATING SYSTEM:"
    cat /etc/os-release | head -n 6

    echo ""
    echo "KERNEL VERSION:"
    uname -r

    echo ""
    echo "CPU INFORMATION:"
    lscpu | head -n 15

    echo ""
    echo "MEMORY INFORMATION:"
    free -h

    echo ""
    echo "DISK USAGE:"
    df -h

    echo ""
    echo "AVAILABLE DISK SPACE:"
    df -h /

    echo ""
    echo "REPORT COMPLETED"
    echo "Student: $STUDENT"
    echo "=================================="

} | tee -a "$LOG_FILE"
