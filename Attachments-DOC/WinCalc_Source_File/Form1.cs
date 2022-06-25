using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WinCalc
{
    public partial class WinCalc : Form
    {
        private Double storedValue = 0;
        private String function = "";
        public WinCalc()
        {
            InitializeComponent();
        }

        private void WinCalc_Load(object sender, EventArgs e)
        {

        }

        // NUMBER BUTTONS
        private void btn_0_Click(object sender, EventArgs e)
        {
            lbl_box.Text = lbl_box.Text + "0";

        }
        private void btn_1_Click(object sender, EventArgs e)
        {
            lbl_box.Text = lbl_box.Text + "1";
        }

        private void btn_2_Click(object sender, EventArgs e)
        {
            lbl_box.Text = lbl_box.Text + "2";
        }

        private void btn_3_Click(object sender, EventArgs e)
        {
            lbl_box.Text = lbl_box.Text + "3";
        }

        private void btn_4_Click(object sender, EventArgs e)
        {
            lbl_box.Text = lbl_box.Text + "4";
        }

        private void btn_5_Click(object sender, EventArgs e)
        {
            lbl_box.Text = lbl_box.Text + "5";
        }

        private void btn_6_Click(object sender, EventArgs e)
        {
            lbl_box.Text = lbl_box.Text + "6";
        }

        private void btn_7_Click(object sender, EventArgs e)
        {
            lbl_box.Text = lbl_box.Text + "7";
        }

        private void btn_8_Click(object sender, EventArgs e)
        {
            lbl_box.Text = lbl_box.Text + "8";
        }

        private void btn_9_Click(object sender, EventArgs e)
        {
            lbl_box.Text = lbl_box.Text + "9";
        }

        // FUNCTION BUTTONS
        private void btn_divide_Click(object sender, EventArgs e)
        {
            storedValue = Convert.ToDouble(lbl_box.Text);
            function = "/";
            lbl_box.Clear();
        }

        private void btn_multi_Click(object sender, EventArgs e)
        {
            storedValue = Convert.ToDouble(lbl_box.Text);
            function = "x";
            lbl_box.Clear();
        }

        private void btn_minus_Click(object sender, EventArgs e)
        {
            storedValue = Convert.ToDouble(lbl_box.Text);
            function = "-";
            lbl_box.Clear();
        }

        private void btn_add_Click(object sender, EventArgs e)
        {
            storedValue = Convert.ToDouble(lbl_box.Text);
            function = "+";
            lbl_box.Clear();
        }

        private void btn_equal_Click(object sender, EventArgs e)
        {
            Double result = 0;

            switch (function)
            {
                case "/":
                    result = storedValue / Convert.ToDouble(lbl_box.Text);
                    break;
                case "x":
                    result = storedValue * Convert.ToDouble(lbl_box.Text);
                    break;
                case "-":
                    result = storedValue - Convert.ToDouble(lbl_box.Text);
                    break;
                case "+":
                    result = storedValue + Convert.ToDouble(lbl_box.Text);
                    break;
                default:
                    lbl_box.Text = "Error";
                    break;


            }
            if (lbl_box.Text != "Error")
            {
                lbl_box.Text = result.ToString();
            }
        }

        private void btn_del_Click(object sender, EventArgs e)
        {
            if (lbl_box.Text != "")
            {
                lbl_box.Text = lbl_box.Text.Remove(lbl_box.Text.Length - 1, 1);
            }
        }

        private void btn_clear_Click(object sender, EventArgs e)
        {
            lbl_box.Clear();
            storedValue = 0;
        }

        private void btn_dot_Click(object sender, EventArgs e)
        {
            lbl_box.Text = lbl_box.Text + ".";
        }

        private void btn_neg_Click(object sender, EventArgs e) // Makes positive number negative
        {
            lbl_box.Text = "-" + lbl_box.Text;
        }
    }
}
