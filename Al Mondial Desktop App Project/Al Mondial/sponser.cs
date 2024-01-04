using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Al_Mondial
{
    public partial class sponser : Form
    {
        public sponser()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Controller c = new Controller();//add
            int check = c.Insertsponser(textBox1.Text.ToString());
            if (check != 0)
            {
                MessageBox.Show("success");
            }
            else
            {
                MessageBox.Show("failed");
            }

        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void button2_Click(object sender, EventArgs e)
        {
            Controller c = new Controller();
            int check = c.Deletesponser(textBox1.Text.ToString());
            if (check != 0)
            {
                MessageBox.Show("success");
            }
            else
            {
                MessageBox.Show("failed");
            }
        }

        private void button2_Click_1(object sender, EventArgs e)
        {
            Controller c = new Controller();
            int check = c.Deletesponser(textBox1.Text.ToString());
            if (check != 0)
            {
                MessageBox.Show("success");
            }
            else
            {
                MessageBox.Show("failed");
            }
        }
    }
}
