using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Runtime.InteropServices;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Al_Mondial
{
    public partial class Ticket : Form
    {
        Controller controller;
        public Ticket()
        {
            InitializeComponent();
           controller=new Controller();
            DataTable dt = controller.SelectAllMatches();
            comboBox1.DataSource = dt;
            comboBox1.DisplayMember = "Match_id";
            comboBox1.Refresh();
         
            comboBox2.Enabled = false;
            comboBox3.Enabled = false;
            DataTable dt3 = controller.SelectAllTickets();
            comboBox4.DataSource = dt3;
            comboBox4.DisplayMember = "Ticket_id";
            button2.Enabled = false;




        }

        private void button5_Click(object sender, EventArgs e)
        {
            if(numericUpDown1.Value==0)
            {
                MessageBox.Show("No Such Id Provided");
                return;
            }
            if(textBox1.Text.Length==0)
            {
                MessageBox.Show("Enter A Cost");
                return;

            }
            int res = controller.AddTicket((int)numericUpDown1.Value, Int32.Parse(textBox1.Text.ToString()), Int32.Parse(comboBox1.Text.ToString()));
            if (res == 0)
                MessageBox.Show("Error Occured");
            else
                MessageBox.Show("Added Successfully");
        }

        private void button1_Click(object sender, EventArgs e)
        {
            button2.Enabled = true;
            comboBox2.Enabled = true; 
            comboBox3.Enabled = true;
            DataTable dt = controller.SelectAllTickets();
            comboBox2.DataSource = dt;
            comboBox2.DisplayMember = "Ticket_id";
            DataTable dt2 = controller.SelectAllUsers();
            comboBox3.DataSource = dt2;
            comboBox3.DisplayMember = "Name";
            comboBox3.ValueMember = "Username";
        }

        private void groupBox1_Enter(object sender, EventArgs e)
        {
      



        }

        private void numericUpDown1_ValueChanged(object sender, EventArgs e)
        {

        }

        private void button2_Click(object sender, EventArgs e)
        {
           DataTable dt = controller.SelectUserWallet(comboBox3.SelectedValue.ToString());
            int Wallet = (int)dt.Rows[0][0];
            DataTable dt2 = controller.SelectTicketCost(Int32.Parse(comboBox2.Text));
            int cost = (int)dt2.Rows[0][0];
            if(cost>Wallet)
            {
                MessageBox.Show("Not Enough Money In User Cost");
                return;
            }
            DataTable dt3 = controller.GetCapacity(Int32.Parse(comboBox2.Text));
            int capacity = (int)dt3.Rows[0][0];
            DataTable dt4 = controller.GetTicketsCount(Int32.Parse(comboBox2.Text));
            int count = dt4.Rows.Count;
            if(capacity<count)
            {
                MessageBox.Show("Capacity Is Full,Please Drop That Ticket");
                return;
            }
            








            int res = controller.AssignTicket(Int32.Parse(comboBox2.Text.ToString()), comboBox3.SelectedValue.ToString());
            if (res == 0)
                MessageBox.Show("Error Occured");
            else
                MessageBox.Show("Assigned Successfully");
        }

        private void comboBox4_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void button3_Click(object sender, EventArgs e)
        {
            int res = controller.DropTicket(Int32.Parse(comboBox4.Text.ToString()));
            if (res == 0)
                MessageBox.Show("Error Occured");
            else
                MessageBox.Show("Droped Successfully");
        }
    }
}
