using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WinGallery
{
    public partial class WinGallery : Form
    {
        public WinGallery()
        {
            InitializeComponent();
        }

        private void WinGallery_Load(object sender, EventArgs e)
        {
            pictureBox1.Image = Properties.Resources.img1;
            label1.Text = "Blue Image";
        }

        private int counter = 1;

        private void btn_next_Click(object sender, EventArgs e)
        {
            counter++;
            if (counter > 2)
            {
                counter = 2;
            }
            if (counter == 1)
            {
                pictureBox1.Image = Properties.Resources.img1;
                label1.Text = "Blue Image";
            }
            if (counter == 2)
            {
                pictureBox1.Image = Properties.Resources.img3;
                label1.Text = "Green Image";
            }
            

        }

        private void btn_back_Click(object sender, EventArgs e)
        {
            counter--;
            if (counter < 0)
            {
                counter = 0;
            }
            if (counter == 1)
            {
                pictureBox1.Image = Properties.Resources.img1;
                label1.Text = "Blue Image";
            }
            if (counter == 0)
            {
                pictureBox1.Image = Properties.Resources.img2;
                label1.Text = "Red Image";
            }
        }


    }
}
